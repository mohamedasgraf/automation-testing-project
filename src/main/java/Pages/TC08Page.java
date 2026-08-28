package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC08Page {
    public By pimLocator = By.cssSelector("a[href*='viewPimModule']");
    public By addBtnLocator = By.cssSelector("div.orangehrm-header-container > button.oxd-button--secondary");
    public By firstNameFeildLocator = By.name("firstName");
    public By lastNameFeildLocator = By.name("lastName");
    public By saveBtnLocator = By.cssSelector("div.oxd-form-actions > button.orangehrm-left-space");
    public By employeeListLocator = By.linkText("Employee List");
    public By employeeNameFeildLocator=By.cssSelector("div.oxd-autocomplete-text-input input");
    public By searchBtnLocator = By.className("orangehrm-left-space");
    public By employeeNameInTableLocator = By.cssSelector("div.card-item.card-body-slot > div:nth-child(1) > div > div.data");
    public WebDriver driver;
    private WebDriverWait wait;


    public TC08Page(WebDriver driver, WebDriverWait wait) {


        this.driver = driver;
        this.wait = wait;
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
                ExpectedConditions.elementToBeClickable(saveBtnLocator)
        );
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

    public WebElement employeeListLElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(employeeListLocator)
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

    @Step("get current URL")
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
    @Step("add new employee with right data")
    public void AddEmployee(String firstname,String lastname){
        firstNameFeildElement().sendKeys(firstname);
        lastNameFeildElement().sendKeys(lastname);
    }
    @Step("click on save button")
    public void clickOnSaveBtn(){

        saveBtnElement().click();
    }
    @Step("navigate to employee list")
    public void navigateToEmployeeList(){
        employeeListLElement().click();
    }

    @Step("enter the employee name to search for ")
    public void enterEmployeeNameToSearchFor(String name) {

        employeeNameFeildElement().sendKeys(name);
    }

    @Step("click on search button")

    public void clickOnSearchBtn() {

        searchBtnElement().click();
    }

    @Step("check his name in the table")
    public WebElement employeeNameInTableElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        employeeNameInTableLocator
                )
        );
    }
}

