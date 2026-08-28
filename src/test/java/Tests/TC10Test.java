package Tests;

import Base.BaseTest;
import Base.LoginData;
import Pages.LoginPage;
import Pages.TC10Page;
import io.qameta.allure.Allure;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataReader;

import java.io.IOException;

public class TC10Test extends BaseTest {


    private TC10Page tc10page;
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

    @Test(dataProvider ="validLoginCredentials",description = "Validate that all pages footer contains the branding link")
    public void  checkFooterForBrandingLink(String username,String password ){
        tc10page=new TC10Page(this.driver.get(),wait.get());
        loginPage=new LoginPage(this.driver.get(),wait.get());

        loginPage.login(username,password);

        Allure.step("Verify that the footer text contains 'OrangeHRM, Inc' ",()->{
            Assert.assertTrue(tc10page.getCopyRightsTextElement().getText().contains("OrangeHRM, Inc"));
        });

        tc10page.clickOnCopyRightsLink();
        wait.get().until(ExpectedConditions.urlContains("orangehrm.com"));

        Allure.step("Verify that  the new tab URL contains orangehrm.com ",()->{
            Assert.assertTrue(tc10page.getCurrentURL().contains("orangehrm.com"));
        });














    }
}
