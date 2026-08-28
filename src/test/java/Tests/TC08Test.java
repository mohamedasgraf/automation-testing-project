package Tests;

import Base.BaseTest;
import Base.LoginData;
import Pages.LoginPage;
import Pages.TC08Page;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataReader;

import java.io.IOException;

public class TC08Test extends BaseTest {

    private TC08Page tc8page;
    private LoginPage loginPage;
    private JsonDataReader loginCredential = new JsonDataReader();

    @DataProvider(name = "validLoginCredentials")
    public Object[][] validLoginCredentials() throws IOException {

        LoginData[] loginData = loginCredential.readLoginData();

        return new Object[][] {
                {
                        loginData[0].getUsername(),
                        loginData[0].getPassword(),
                        loginData[4].getFirstName(),
                        loginData[4].getLastName()

                }
        };
    }

    @Test(dataProvider ="validLoginCredentials",description = "Validate when we navigate to add employee page we can add new employee when we fill all required fields")
    public void  addNewEmployee(String username,String password,String firstName,String lastName ){
        tc8page=new TC08Page(this.driver.get(),wait.get());
        loginPage=new LoginPage(this.driver.get(),wait.get());

        loginPage.login(username,password);
        tc8page.navigateToPim();
        tc8page.clickOnAddBtn();
        tc8page.AddEmployee(firstName,lastName);
        tc8page.clickOnSaveBtn();

        Allure.step("Verify that   Personal Details page opens for the newly created employee",()->{
            Assert.assertTrue(tc8page.getCurrentURL().contains("pim/viewPersonalDetails"));
        });

        tc8page.navigateToEmployeeList();
        tc8page.enterEmployeeNameToSearchFor(firstName);
        tc8page.clickOnSearchBtn();

        Allure.step("Verify that  the new employee appears in the results",()->{
            Assert.assertEquals(tc8page.employeeNameInTableElement().getText(),firstName);
        });










    }

}
