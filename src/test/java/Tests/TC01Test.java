package Tests;

import Base.BaseTest;
import Base.LoginData;
import Pages.TC01Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataReader;

import java.io.IOException;

public class TC01Test extends BaseTest {
    private TC01Page tc1page;
    private JsonDataReader loginCredential = new JsonDataReader();




    @DataProvider(name = "validLoginCredentials")
    public Object[][] validLoginCredentials() throws IOException {

        LoginData[] loginData = loginCredential.readLoginData();

        return new Object[][] {
                {
                        loginData[0].getUsername(),
                        loginData[0].getPassword()
                }
        };
    }

    @Test(dataProvider ="validLoginCredentials",description = "Validate login with the valid credentials will navigate us to dashboard ")
    public void  loginWithValidCredentials(String username,String password ){

        tc1page=new TC01Page(this.driver.get(),wait.get());


        tc1page.loginFormRegestration(username,password);
        tc1page.clickOnLoginButton();
        Allure.step("Verify URL contains /dashboard/index",()->{
            Assert.assertTrue(tc1page.getCurrentURL().contains("/dashboard/index"));
                });
        Allure.step("Verify Dashboard header is displayed",()->{
            Assert.assertEquals(tc1page.getDashboardHeader().getText(),"Dashboard");
        });




    }
}
