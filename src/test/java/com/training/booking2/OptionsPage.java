package com.training.booking2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OptionsPage extends BasePage {
    By lowestPrice = By.partialLinkText("Price (lowest first)");
    By availability = By.partialLinkText("See availability");
    WebElement reserveBtn = driver.findElements(By.cssSelector("span[class='b-button__text']")).get(1);
    By numRooms = By.xpath("//*[@id=\"hprt_nos_select_534593501_189325125_4_1_0\"]");
    By reserveBtn2 = By.id("b_tt_holder_3");
    By hotelName = By.id("hp_hotel_name");

    public OptionsPage(WebDriver driver) {
        super(driver);
    }
    public void reserve() throws InterruptedException {
        driver.findElement(lowestPrice).click();
        Thread.sleep(2000);
        driver.findElement(availability).click();
        Thread.sleep(2000);
//        WebDriverWait ewait = new WebDriverWait(driver,10);
//        ewait.until(ExpectedConditions.titleContains("Chile - Booking.com"));

        //driver.findElements(By.cssSelector("span[class='b-button__text']")).get(1).click();

//        WebDriverWait ewait2 = new WebDriverWait(driver,10);
//        ewait2.until(ExpectedConditions.elementToBeClickable(driver.findElements(By.cssSelector("span[class='b-button__text']")).get(1)));

//        if(Integer.parseInt(driver.findElement(numRooms).getText())==0){
//            System.out.println("You have to set the number of rooms");
//        }
        System.out.println(driver.findElement(hotelName).getText());
        driver.findElements(By.cssSelector("span[class='b-button__text']")).get(6).click();
        //driver.findElement(reserveBtn2).click();
    }

    public String getHotelName() {
        return driver.findElement(hotelName).getText();
    }
}
