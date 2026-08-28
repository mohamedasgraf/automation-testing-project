package Tests;

import Base.BaseTest;
import Base.LoginData;
import Pages.LoginPage;
import Pages.TC04Page;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataReader;

import java.io.IOException;

public class TC04Test extends BaseTest {

    private TC04Page tc4page;
    private LoginPage loginPage;
    private JsonDataReader loginCredential = new JsonDataReader();




    @DataProvider(name = "validLoginCredentials")
    public Object[][] validLoginCredentials() throws IOException {

        LoginData[] loginData = loginCredential.readLoginData();

        return new Object[][] {
                {
                        loginData[0].getUsername(),
                        loginData[0].getPassword(),
                        loginData[3].getexistingName()
                }
        };
    }

    @Test(dataProvider ="validLoginCredentials",description = "Validate we can navigate to pim page and search for an existing employee ")
    public void  searchForEmployee(String username,String password,String existingName ){

        tc4page=new TC04Page(this.driver.get(),wait.get());
        loginPage=new LoginPage(this.driver.get(),wait.get());


        loginPage.login(username,password);
        tc4page.navigateToPim();
        tc4page.enterKnownEmployeeName(existingName);
        tc4page.clickOnSearchBtn();
        Allure.step("Verify the employee we type his name displayed in the employee card after search",()->{
            Assert.assertEquals(tc4page.employeeNameInTableElement().getText(),existingName);
        });




    }
}
