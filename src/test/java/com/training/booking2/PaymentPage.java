package com.training.booking2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    private String hotelName;
    By checkInDate = By.xpath("//*[@id=\"fullwidth\"]/div[2]/div[1]/div[2]/ul/li[1]/div[2]/strong");
    By checkOutDate = By.xpath("//*[@id=\"fullwidth\"]/div[2]/div[1]/div[2]/ul/li[2]/div[2]/strong");
    By hotelNameConf = By.xpath("//*[@id=\"bookOverviewTop\"]/div[1]/div[2]/div[1]/h1");
    By hotelPriceConf = By.cssSelector("span[class='bp_pricedetails_breakdown_price']");
    Hotel hotel;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    public Boolean confirmHotel(){
        hotel = new Hotel();
        System.out.println(driver.findElement(checkInDate).getText());
        System.out.println(driver.findElement(checkOutDate).getText());
        System.out.println(driver.findElement(hotelPriceConf).getText());
        System.out.println("--------------------------------------------");
        System.out.println(hotel.getPrice());


        if (driver.findElement(checkInDate).getText().equals("Monday, September 23, 2019")
                && driver.findElement(checkOutDate).getText().equals("Monday, September 27, 2019")
                && driver.findElement(hotelPriceConf).getText().equals(hotel.getPrice())){
            System.out.println("The hotel information matches!!!");
            return true;
        }
        System.out.println("The hotel information doesn't match!!!");
        return false;
    }
}
