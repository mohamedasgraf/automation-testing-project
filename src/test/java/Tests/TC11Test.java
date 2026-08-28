package Tests;

import Base.BaseTest;
import Base.LoginData;
import Pages.LoginPage;
import Pages.TC11Page;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataReader;

import java.io.IOException;
import java.util.List;

public class TC11Test extends BaseTest {

    private TC11Page tc11page;
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

    @Test(dataProvider ="validLoginCredentials",
            description = "Validate that the side menu display the right choices  Admin, PIM, Leave, Time, Recruitment, My Info, Performance,Dashboard, Directory  ")
    public void  verifySidebarMenuUI(String username,String password ){
        tc11page=new TC11Page(this.driver.get(),wait.get());
        loginPage=new LoginPage(this.driver.get(),wait.get());

        loginPage.login(username,password);
        List<String> expectedMenuItems=List.of("Admin", "PIM", "Leave", "Time", "Recruitment", "My Info", "Performance","Dashboard", "Directory");
        List<String> actualMenuItems=tc11page.getSidebarMenueText();

        Allure.step("Verify that  t the sidebar menu contains: Admin, PIM, Leave, Time, Recruitment, My Info, Performance, Dashboard, Directory ",()->{
            for (String item : expectedMenuItems) {
                Assert.assertTrue(actualMenuItems.contains(item), "Missing menu item: " + item);
            }
        });



    }
}
