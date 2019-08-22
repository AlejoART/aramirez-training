package com.training.booking2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    By checkInDate = By.xpath("//*[@id=\"fullwidth\"]/div[2]/div[1]/div[2]/ul/li[1]/div[2]/strong");
    By checkOutDate = By.xpath("//*[@id=\"fullwidth\"]/div[2]/div[1]/div[2]/ul/li[2]/div[2]/strong");
    By hotelPriceConf = By.cssSelector("span[class='bp_pricedetails_breakdown_price']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public Boolean confirmHotel(String hotelPrice) {
        if (driver.findElement(checkInDate).getText().equals("Monday, September 23, 2019")
                && driver.findElement(checkOutDate).getText().equals("Friday, September 27, 2019")
                && driver.findElement(hotelPriceConf).getText().equals(hotelPrice)) {
            return true;
        }
        return false;
    }
}
