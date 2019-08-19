package com.training.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OptionsPage extends Base {
    //locators here
    By lowestPrice = By.partialLinkText("Price (lowest first)");
    By availability = By.partialLinkText("See availability");
    By reserveBtn = By.linkText("Reserve ");
    By numRooms = By.id("hprt_nos_select_534593501_189325125_4_1_0");
    By reserveBtn2 = By.id("b_tt_holder_4");
    By hotelName = By.id("hp_hotel_name");

    public OptionsPage(WebDriver driver) {
        super(driver);
    }

    public void reserve() throws InterruptedException {
        findElement(lowestPrice).click();
        Thread.sleep(2000);
        findElement(availability).click();
        Thread.sleep(2000);
        findElement(reserveBtn).click();
        if(Integer.parseInt(findElement(numRooms).getText())==0){
            System.out.println("You have o set the number of rooms");
        }
        findElement(reserveBtn2).click();
    }

    public String getHotelName() {
        return findElement(hotelName).getText();
    }

}
