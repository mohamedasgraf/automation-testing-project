package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC07Page {
    public By pimLocator=By.cssSelector("a[href*='viewPimModule']");
    public By addBtnLocator=By.cssSelector("div.orangehrm-header-container > button.oxd-button--secondary");
    public By firstNameFeildLocator=By.name("firstName");
    public By lastNameFeildLocator=By.name("lastName");
    public By saveBtnLocator=By.cssSelector("div.oxd-form-actions > button.orangehrm-left-space");
    public By firstNameRequiredMsgLocator=By.xpath("//div[contains(@class,'oxd-input-group')][.//input[@name='firstName']]//span[normalize-space()='Required']");
    public WebDriver driver;
    private WebDriverWait wait;



    public TC07Page(WebDriver driver, WebDriverWait wait) {


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
    public WebElement saveBtnElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(saveBtnLocator)
        );
    }

    public WebElement firstNameRequiredMsgElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstNameRequiredMsgLocator)
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
    @Step("add new employee with empty required field")
    public void AddEmployee(String firstname,String lastname){
        firstNameFeildElement().sendKeys(firstname);
        lastNameFeildElement().sendKeys(lastname);
    }
    @Step("click on save button")
    public void clickOnSaveBtn(){

        saveBtnElement().click();
    }
}
