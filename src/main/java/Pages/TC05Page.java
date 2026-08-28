package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC05Page {
    public By pimLocator=By.cssSelector("a[href*='viewPimModule']");
    public By employeeNameFeildLocator=By.cssSelector("div.oxd-autocomplete-text-input input");
    public By searchBtnLocator=By.className("orangehrm-left-space");
    public By noRecordFoundMsgLocator=By.cssSelector("div.orangehrm-horizontal-padding > span.oxd-text--span");
    public WebDriver driver;
    private WebDriverWait wait;


    public TC05Page(WebDriver driver, WebDriverWait wait) {


        this.driver=driver;
        this.wait=wait;
    }

    public WebElement getPimElement() {
        return wait.until(ExpectedConditions.elementToBeClickable(pimLocator));
    }

    public WebElement employeeNameFeildElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(employeeNameFeildLocator)
        );
    }

    public WebElement searchBtnElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(searchBtnLocator)
        );
    }

    public WebElement noRecordFoundMsgElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        noRecordFoundMsgLocator
                )
        );

    }

    @Step("click on PIM choice from the side menu ")
    public void navigateToPim(){

        getPimElement().click();
    }
    @Step("enter unknown employee name ")
    public void enterUnKnownEmployeeName(String name){

        employeeNameFeildElement().sendKeys(name);
    }
    @Step("click search button ")
    public void clickOnSearchBtn(){

        searchBtnElement().click();
    }









}
