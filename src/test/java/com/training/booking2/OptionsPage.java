package com.training.booking2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OptionsPage extends BasePage {
    By reserveBtn = By.xpath("//*[@id=\"group_recommendation\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/a/span");
    By hotelName = By.xpath("//*[@id=\"hp_hotel_name\"]");//me dice q q esta undefined
    By hotelPrice = By.cssSelector("div[class='bui-price-display__value prco-ltr-center-align-helper prco-font16-helper']");
    By numbRooms = By.cssSelector("#hprt_nos_select_534593501_189325125_4_1_0");
    By errorMsg = By.xpath("//*[@id=\"hprt-table\"]/tbody/tr/td[5]/div/div/div/p/span");

    public OptionsPage(WebDriver driver) {
        super(driver);
    }
    public void reserve() throws InterruptedException {

        //driver.findElement(reserveBtn).click();

//        if(Integer.parseInt(driver.findElement(numRooms).getText())==0){
//            System.out.println("You have to set the number of rooms");
//        }
        Thread.sleep(5000);
        driver.findElements(By.cssSelector("button[type='submit']")).get(2).click();

        WebDriverWait ewait = new WebDriverWait(driver, 10);
        ewait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));

        Select selectList = new Select(driver.findElement(numbRooms));
        selectList.selectByValue("1");

        driver.findElements(By.cssSelector("button[type='submit']")).get(2).click();
    }

    public String getHotelName() {
        return driver.findElement(hotelName).getText();
    }

    public String getHotelPrice() {
        return driver.findElement(hotelPrice).getText();
    }

}
