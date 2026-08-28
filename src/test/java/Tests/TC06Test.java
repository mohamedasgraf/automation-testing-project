package Tests;

import Base.BaseTest;
import Base.LoginData;
import Pages.LoginPage;
import Pages.TC06Page;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataReader;

import java.io.IOException;

public class TC06Test extends BaseTest {

    private TC06Page tc6page;
    private LoginPage loginPage;
    private JsonDataReader loginCredential = new JsonDataReader();

    @DataProvider(name = "validLoginCredentials")
    public Object[][] validLoginCredentials() throws IOException {

        LoginData[] loginData = loginCredential.readLoginData();

        return new Object[][] {
                {
                        loginData[0].getUsername(),
                        loginData[0].getPassword(),
                }
        };
    }

    @Test(dataProvider ="validLoginCredentials",description = "Validate when login and navigate to pim page we can open add employee page")
    public void  openAddEmployeePage(String username,String password){
        tc6page=new TC06Page(this.driver.get(),wait.get());
        loginPage=new LoginPage(this.driver.get(),wait.get());

        loginPage.login(username,password);
        tc6page.navigateToPim();
        tc6page.clickOnAddBtn();
        Allure.step("Verify the current url contains /pim/addEmployee",()->{
            Assert.assertTrue(tc6page.getCurrentURL().contains("/pim/addEmployee"));
        });
        Allure.step("Verify that add employee page display the first name field",()->{
            Assert.assertTrue(tc6page.firstNameFeildElement().isDisplayed());
        });
        Allure.step("Verify that add employee page display the last name field",()->{
            Assert.assertTrue(tc6page.lastNameFeildElement().isDisplayed());
        });













    }

}
