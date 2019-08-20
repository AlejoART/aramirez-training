package com.training.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OptionsPage extends BasePage {
    //locators here
    By lowestPrice = By.partialLinkText("Price (lowest first)");
    By availability = By.partialLinkText("See availability");
    By reserveBtn = By.xpath("//*[@id=\"group_recommendation\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/a");
    By numRooms = By.id("hprt_nos_select_534593501_189325125_4_1_0");
    By reserveBtn2 = By.id("b_tt_holder_1b_tt_holder_1");
    By hotelName = By.id("hp_hotel_name");

    public OptionsPage(WebDriver driver){ super(driver);
    }

    public void reserve() throws InterruptedException {
        findElement(lowestPrice).click();
        Thread.sleep(2000);
        findElement(availability).click();

        WebDriverWait ewait = new WebDriverWait(chromeDriverConnection(),10);
        ewait.until(ExpectedConditions.titleContains("Chile - Booking.com"));

        findElement(reserveBtn).click();

        WebDriverWait ewait2 = new WebDriverWait(chromeDriverConnection(),10);
        ewait2.until(ExpectedConditions.elementToBeClickable(reserveBtn2));

        if(Integer.parseInt(findElement(numRooms).getText())==0){
            System.out.println("You have o set the number of rooms");
        }
        findElement(reserveBtn2).click();
    }

    public String getHotelName() {
        return findElement(hotelName).getText();
    }

}
