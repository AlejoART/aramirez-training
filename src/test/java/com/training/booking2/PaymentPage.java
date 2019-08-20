package com.training.booking2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    private String hotelName;

    By hotelNameConf = By.xpath("//*[@id=\"bookOverviewTop\"]/div[1]/div[2]/div[1]/h1");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    public void confirmHotel(){

    }
}
