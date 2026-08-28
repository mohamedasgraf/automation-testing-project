package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TC09Page {
    public WebDriver driver;
    private WebDriverWait wait;
    private By adminLocator=By.xpath("//a[.//span[text()='Admin']]");
    private By userManagmentLocator=By.cssSelector("li.--active.oxd-topbar-body-nav-tab > span");
    private By usersLocator=By.linkText("Users");
    private By addBtnLocator=By.cssSelector("div.orangehrm-header-container > button.oxd-button--secondary");
    private By userRoleLocator=By.cssSelector(".oxd-grid-2 > .oxd-grid-item:nth-child(1) .oxd-select-text-input");
    private By employeeNameFeildLocator=By.cssSelector("input[placeholder='Type for hints...']");
    private By userNameFeildLocator=By.xpath("//label[normalize-space()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By passwordFieldLocator = By.xpath("//label[normalize-space()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private By confirmPasswordFieldLocator = By.xpath("//label[normalize-space()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input");


    public TC09Page(WebDriver driver, WebDriverWait wait) {


        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getAdminElement(){
        return wait.until(
                ExpectedConditions.elementToBeClickable(adminLocator)
        );
    }

    public WebElement getUserManagmentElement(){
        return wait.until(
                ExpectedConditions.elementToBeClickable(userManagmentLocator)
        );
    }

    public WebElement getUserElement(){
        return wait.until(
                ExpectedConditions.elementToBeClickable(usersLocator)
        );
    }
    public WebElement addBtnElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(addBtnLocator)
        );
    }

    public WebElement userRoleFeildElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(userRoleLocator)
        );
    }

    public WebElement employeeNameFeildElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(employeeNameFeildLocator)
        );
    }

    public WebElement userNameFeildElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(userNameFeildLocator)
        );
    }

    public WebElement passwordFieldElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator)
        );
    }

    public WebElement confirmPasswordFieldElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmPasswordFieldLocator)
        );
    }


    @Step("navigate to Admin")
    public void navigateToAdmin() {

        getAdminElement().click();
    }

    @Step("click on users Management Tab")

    public void clickOnUserManagement() {

        getUserManagmentElement().click();
    }

    @Step("navigate to users")
    public void navigateToUsers() {

        getUserElement().click();
    }

    @Step("click on add button")
    public void clickOnAddBtn() {

        addBtnElement().click();
    }








}
