package Tests;

import Base.BaseTest;
import Base.LoginData;
import Pages.LoginPage;
import Pages.TC06Page;
import Pages.TC07Page;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataReader;

import java.io.IOException;

public class TC07Test extends BaseTest {

    private TC07Page tc7page;
    private LoginPage loginPage;
    private JsonDataReader loginCredential = new JsonDataReader();

    @DataProvider(name = "validLoginCredentials")
    public Object[][] validLoginCredentials() throws IOException {

        LoginData[] loginData = loginCredential.readLoginData();

        return new Object[][] {
                {
                        loginData[0].getUsername(),
                        loginData[0].getPassword(),
                        loginData[4].getEmptyFirstName(),
                        loginData[4].getLastName()

                }
        };
    }

    @Test(dataProvider ="validLoginCredentials",description = "Validate when we try to add employee with empty required field it will be rejected")
    public void  addEmployeeWithEmptyFirstNameFeild(String username,String password,String emptyFirstName,String lastName ){
        tc7page=new TC07Page(this.driver.get(),wait.get());
        loginPage=new LoginPage(this.driver.get(),wait.get());

        loginPage.login(username,password);
        tc7page.navigateToPim();
        tc7page.clickOnAddBtn();
        tc7page.AddEmployee(emptyFirstName,lastName);
        tc7page.clickOnSaveBtn();
        Allure.step("Verify that  validation error Required is displayed under First Name",()->{
            Assert.assertEquals(tc7page.firstNameRequiredMsgElement().getText(),"Required");
        });










    }

}
