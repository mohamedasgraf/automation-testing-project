package Tests;

import Base.BaseTest;
import Base.LoginData;
import Pages.LoginPage;
import Pages.TC09Page;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataReader;

import java.io.IOException;

public class TC09Test extends BaseTest {

    private TC09Page tc9page;
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

    @Test(dataProvider ="validLoginCredentials",description = "Validate that admin can access the add user page and all form fields are visible  ")
    public void  checkAddUserPageFormFields(String username,String password ){
        tc9page=new TC09Page(this.driver.get(),wait.get());
        loginPage=new LoginPage(this.driver.get(),wait.get());

        loginPage.login(username,password);
        tc9page.navigateToAdmin();
        tc9page.clickOnUserManagement();
        tc9page.navigateToUsers();
        tc9page.clickOnAddBtn();

        Allure.step("Verify that the Add User form contains User Role field",()->{
            Assert.assertTrue(
                    tc9page.userRoleFeildElement().isDisplayed(),
                    "userRole list is not visible"
            );
        });
        Allure.step("Verify that the Add User form contains  Employee Name field",()->{
            Assert.assertTrue(
                    tc9page.employeeNameFeildElement().isDisplayed(),
                    "employee Name field is not visible"
            );
        });
        Allure.step("Verify that the Add User form contains User  Username field",()->{
            Assert.assertTrue(
                    tc9page.userNameFeildElement().isDisplayed(),
                    "userName field is not visible"
            );
        });
        Allure.step("Verify that the Add User form contains  Password fields",()->{
            Assert.assertTrue(
                    tc9page.passwordFieldElement().isDisplayed(),
                    "password field is not visible"
            );

            Assert.assertTrue(
                    tc9page.confirmPasswordFieldElement().isDisplayed(),
                    "confirmPassword field is not visible"
            );
        });














    }
}

