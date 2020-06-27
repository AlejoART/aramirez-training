package training.booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;

public class BaseTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver","src/test/java/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.booking.com");
    }

    @AfterSuite
    public void afterSuite(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void switchToTab(int tab) {
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        //Use the list of window handles to switch between windows
        driver.switchTo().window((String) tabs.get(tab - 1));
    }
}
