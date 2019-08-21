package com.training.booking2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OptionsPage extends BasePage {
    By lowestPrice = By.partialLinkText("Price (lowest first)");
    By availability = By.partialLinkText("See availability");
    By reserveBtn = By.xpath("//*[@id=\"group_recommendation\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/a/span");
//    By numRooms = By.xpath("//*[@id=\"hprt_nos_select_534593501_189325125_4_1_0\"]");
//    By reserveBtn2 = By.cssSelector("#b_tt_holder_1");
    By hotelName = By.xpath("//*[@id=\"hp_hotel_name\"]");//me dice q q esta undefined
    By hotelPrice = By.cssSelector("div[class='bui-price-display__value prco-ltr-center-align-helper prco-font16-helper']");

    public OptionsPage(WebDriver driver) {
        super(driver);
    }
    public void reserve() throws InterruptedException {
        driver.findElement(lowestPrice).click();
        Thread.sleep(2000);
        driver.findElement(availability).click();
        Thread.sleep(2000);

        switchToTab(2);

        /*WebDriverWait ewait2 = new WebDriverWait(driver,10);
        ewait2.until(ExpectedConditions.titleContains("Chile - Booking.com"));
*/

//        driver.findElements(By.cssSelector("span[class='b-button__text']")).get(1).click();
        driver.findElement(reserveBtn).click();
        //Thread.sleep(5000);

//        if(Integer.parseInt(driver.findElement(numRooms).getText())==0){
//            System.out.println("You have to set the number of rooms");
//        }
        Thread.sleep(5000);
        Hotel hotel = new Hotel();
        hotel.setPrice(driver.findElement(hotelPrice).getText());
        driver.findElements(By.cssSelector("button[type='submit']")).get(2).click();

        //driver.findElement(reserveBtn2).click();
    }

    public String getHotelName() {
        return driver.findElement(hotelName).getText();
    }

}
