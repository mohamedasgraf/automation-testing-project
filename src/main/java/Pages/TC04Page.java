package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC04Page {

    public By pimLocator=By.cssSelector("a[href*='viewPimModule']");
    public By employeeNameFeildLocator=By.cssSelector("div.oxd-autocomplete-text-input input");
    public By searchBtnLocator=By.className("orangehrm-left-space");
    public By employeeNameInTableLocator=By.xpath("(//div[contains(@class,'data')])[2]");
    public WebDriver driver;
    private WebDriverWait wait;


    public TC04Page(WebDriver driver, WebDriverWait wait) {


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

    public WebElement employeeNameInTableElement() {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        employeeNameInTableLocator
                )
        );
    }



    @Step("click on PIM choice from the side menu ")
    public void navigateToPim(){

        getPimElement().click();
    }
    @Step("enter known employee name ")
    public void enterKnownEmployeeName(String name){

        employeeNameFeildElement().sendKeys(name);
    }

    @Step("click search button ")

    public void clickOnSearchBtn(){

        searchBtnElement().click();
    }









}
