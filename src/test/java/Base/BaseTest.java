package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

import java.time.Duration;

public class BaseTest {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    public String URL;
    public String browser;

    ConfigReader reader = new ConfigReader();

    @BeforeMethod
    public void before_testcases() {

        browser = reader.getBrowser();

        if (browser.equals("chrome")) {
            driver.set(new ChromeDriver());
        }

        int waiting_seconds = reader.getExplicitWait();

        wait.set(
                new WebDriverWait(
                        driver.get(),
                        Duration.ofSeconds(waiting_seconds)
                )
        );

        URL = reader.getBaseUrl();

        driver.get().get(URL);
    }

    @AfterMethod
    public void after_testcases() {

        if (driver.get() != null) {
            driver.get().quit();
        }

        driver.remove();
        wait.remove();
    }
}
