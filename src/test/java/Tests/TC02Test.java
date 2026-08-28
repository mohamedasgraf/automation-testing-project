package Tests;

import Base.BaseTest;
import Base.LoginData;
import Pages.TC02Page;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataReader;

import java.io.IOException;

public class TC02Test extends BaseTest {
    private TC02Page tc2page;
    private JsonDataReader loginCredential = new JsonDataReader();




    @DataProvider(name = "invalidLoginCredentials")
    public Object[][] invalidLoginCredentials() throws IOException {

        LoginData[] loginData = loginCredential.readLoginData();

        return new Object[][] {
                {
                        loginData[1].getUsername(),
                        loginData[1].getPassword()
                }
        };
    }

    @Test(dataProvider ="invalidLoginCredentials",
            description = "Validate login with the invalid credentials is rejected and show alert ")
    public void  loginWithInvalidCredentials(String username,String password ){

        tc2page=new TC02Page(this.driver.get(),wait.get());


        tc2page.loginFormRegestration(username,password);
        tc2page.clickOnLoginButton();
        Allure.step("Verify you can't login with invalid credentials",()->{
            Assert.assertEquals(tc2page.getInvalidMsgElement().getText(),"Invalid credentials");
        });



    }
}
