package com.training.booking2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    By lowestPrice = By.partialLinkText("Price (lowest first)");
    By availability = By.partialLinkText("See availability");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void checkAvailability() throws InterruptedException {
        driver.findElement(lowestPrice).click();
        Thread.sleep(2000);
        driver.findElement(availability).click();
        Thread.sleep(2000);
    }
}
