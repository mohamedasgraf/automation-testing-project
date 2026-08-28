package Tests;

import Base.BaseTest;
import Base.LoginData;
import Pages.TC03Page;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataReader;

import java.io.IOException;

public class TC03Test extends BaseTest {
    private TC03Page tc3page;
    private JsonDataReader loginCredential = new JsonDataReader();




    @DataProvider(name = "emptyLoginCredentials")
    public Object[][] emptyLoginCredentials() throws IOException {

        LoginData[] loginData = loginCredential.readLoginData();

        return new Object[][] {
                {
                        loginData[2].getUsername(),
                        loginData[2].getPassword()
                }
        };
    }

    @Test(dataProvider ="emptyLoginCredentials",
            description = "Validate login with empty credentials is rejected and show alert ")
    public void  loginWithEmptyFields(String username,String password ){

        tc3page=new TC03Page(this.driver.get(),wait.get());


        tc3page.loginFormRegestration(username,password);
        tc3page.clickOnLoginButton();
        Allure.step("Verify username field required message is displayed",()->{
            Assert.assertEquals(tc3page.getMsgElement().get(0).getText(),"Required");
        });
        Allure.step("Verify password field required message is displayed",()->{
            Assert.assertEquals(tc3page.getMsgElement().get(1).getText(),"Required");
        });




    }
}
