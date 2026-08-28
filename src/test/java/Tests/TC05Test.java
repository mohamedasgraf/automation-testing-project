package Tests;

import Base.BaseTest;
import Base.LoginData;
import Pages.LoginPage;
import Pages.TC05Page;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataReader;

import java.io.IOException;

public class TC05Test extends BaseTest {
    private TC05Page tc5page;
    private LoginPage loginPage;
    private JsonDataReader loginCredential = new JsonDataReader();




    @DataProvider(name = "validLoginCredentials")
    public Object[][] validLoginCredentials() throws IOException {

        LoginData[] loginData = loginCredential.readLoginData();

        return new Object[][] {
                {
                        loginData[0].getUsername(),
                        loginData[0].getPassword(),
                        loginData[3].getnon_existingName()
                }
        };
    }

    @Test(dataProvider ="validLoginCredentials",description = "Validate when search for an Non existing employee it return No Records Found ")
    public void  searchForUnexistingEmployee(String username,String password,String non_existingName ){

        tc5page=new TC05Page(this.driver.get(),wait.get());
        loginPage=new LoginPage(this.driver.get(),wait.get());


        loginPage.login(username,password);
        tc5page.navigateToPim();
        tc5page.enterUnKnownEmployeeName(non_existingName);
        tc5page.clickOnSearchBtn();
        Allure.step("Verify when search for unknown employee no records found",()->{
            Assert.assertEquals(tc5page.noRecordFoundMsgElement().getText(),"No Records Found");
        });



    }
}
