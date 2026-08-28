package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public WebDriver driver;
    public WebDriverWait wait;

    public By usernameLocator = By.name("username");
    public By passwordLocator = By.name("password");
    public By loginBtnLocator = By.className("orangehrm-login-button");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getUsernameElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameLocator)
        );
    }

    public WebElement getPasswordElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordLocator)
        );
    }

    public WebElement getLoginBtnElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(loginBtnLocator)
        );
    }
    @Step("Login to the system")
    public void login(String username, String password) {
        getUsernameElement().sendKeys(username);
        getPasswordElement().sendKeys(password);
        getLoginBtnElement().click();
    }
}
