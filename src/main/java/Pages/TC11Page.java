package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TC11Page {

    public WebDriver driver;
    private WebDriverWait wait;
    private By sidebarMenuLocator=By.cssSelector("ul.oxd-main-menu");

    public TC11Page(WebDriver driver, WebDriverWait wait) {


        this.driver = driver;
        this.wait = wait;
    }


    public WebElement getSidebarMenuElement(){
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(sidebarMenuLocator)
        );
    }
    @Step("verify the side menu display the right sections")
    public List<String> getSidebarMenueText(){
        List<WebElement> menu = getSidebarMenuElement().findElements(By.tagName("li"));
        return menu.stream().map(WebElement::getText).toList();
    }

}
