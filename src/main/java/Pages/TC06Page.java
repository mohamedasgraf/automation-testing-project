package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC06Page {
    public By pimLocator=By.cssSelector("a[href*='viewPimModule']");
    public By addBtnLocator=By.cssSelector("div.orangehrm-header-container > button.oxd-button--secondary");
    public By firstNameFeildLocator=By.name("firstName");
    public By lastNameFeildLocator=By.name("lastName");
    public WebDriver driver;
    private WebDriverWait wait;



    public TC06Page(WebDriver driver, WebDriverWait wait) {


        this.driver=driver;
        this.wait=wait;
    }

    public WebElement getPimElement() {
        return wait.until(ExpectedConditions.elementToBeClickable(pimLocator));
    }

    public WebElement addBtnElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(addBtnLocator)
        );
    }


    @Step("click on PIM choice from the side menu ")
    public void navigateToPim(){

        getPimElement().click();
    }

    @Step("click add button ")
    public void clickOnAddBtn(){

        addBtnElement().click();
    }

    @Step("get current URL ")
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    @Step("get firstname filed ")
    public WebElement firstNameFeildElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstNameFeildLocator)
        );

    }
    @Step("get lastname filed ")
    public WebElement lastNameFeildElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(lastNameFeildLocator)
        );

    }
}
