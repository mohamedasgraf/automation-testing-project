package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC10Page {
    public WebDriver driver;
    private WebDriverWait wait;
    private By orangeCopyRightsTextLocator=By.cssSelector("div.oxd-layout-footer > p:nth-child(2)");
    private By orangeHRMLINKLocator= By.linkText("OrangeHRM, Inc");

    public TC10Page(WebDriver driver, WebDriverWait wait) {


        this.driver = driver;
        this.wait = wait;
    }

    @Step("scroll down to find footer")
    public WebElement getCopyRightsTextElement(){
        return wait.until(
                ExpectedConditions.elementToBeClickable(orangeCopyRightsTextLocator)
        );
    }

    @Step("check if the footer had the brand link")
    public WebElement getCopyRightsLinkElement(){
        return wait.until(
                ExpectedConditions.elementToBeClickable(orangeHRMLINKLocator)
        );
    }
    @Step("click on the brand link")
    public void clickOnCopyRightsLink() {

        getCopyRightsLinkElement().click();

    }



    @Step("get the current URL")
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }






}
