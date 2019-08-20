package com.training.booking2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver","src/test/java/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void afterSuite(){
        //driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
