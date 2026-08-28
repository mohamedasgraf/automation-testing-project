package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC02Page {
    public WebDriver driver;
    public WebDriverWait wait;
    public By usernameLocator= By.name("username");
    public By passwordLocator= By.name("password");
    public By loginBtnLocator=By.className("orangehrm-login-button");
    public By invalidMsgLocator=By.className("oxd-alert-content--error");


    public TC02Page(WebDriver driver, WebDriverWait wait) {

        this.driver=driver;
        this.wait= wait;
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

    @Step("enter invalid login  credentials ")
    public void loginFormRegestration(String username,String password){
        getUsernameElement().sendKeys(username);
        getPasswordElement().sendKeys(password);
    }
    @Step("click login button ")
    public void clickOnLoginButton(){
        getLoginBtnElement().click();
    }

    @Step("get the rejection message")
    public WebElement getInvalidMsgElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidMsgLocator));
    }
}
