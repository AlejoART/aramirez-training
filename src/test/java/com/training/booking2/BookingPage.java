package com.training.booking2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookingPage extends BasePage {

    By searchBoxLocator = By.id("ss");

    By calendar= By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span");
    By checkIn = By.cssSelector("td[data-date='2019-09-23']");
    By checkOut = By.cssSelector("td[data-date='2019-09-27']");

    By guestsBox = By.cssSelector("span[class=xp__guests__count]");
    By guestBoxToogle = By.xpath("//*[@id=\"xp__guests__toggle\"]"); //cuando das clic aqui aparece o desaparece
    By guestContainer = By.xpath("//*[@id=\"xp__guests__inputs-container\"]");//como checar el att style="display: block|none;"???
    By amounts = By.cssSelector("span[class='bui-stepper__display']");
    By amountsSetters = By.cssSelector("span[class='bui-button__text']");
    By searchButton = By.cssSelector("button[data-sb-id=\"main\"]");

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public void setDestination(String destination){
        driver.findElement(searchBoxLocator).sendKeys(destination);
    }
    public void setBookingDate(){
        driver.findElement(calendar).click();
        driver.findElement(checkIn).click();
        driver.findElement(checkOut).click();
    }

    public int childAmount(){
        List<WebElement> spans;
        spans = driver.findElements(amounts);
        return Integer.parseInt((spans.get(1).getText()));
    }

    public void setChildAmount(){
        driver.findElement(guestBoxToogle).click();
        int childAmount = childAmount();
        List <WebElement> setters = driver.findElements(amountsSetters);
        if(childAmount == 0){
            setters.get(3).click();
        }else{
            while(childAmount > 1){
                setters.get(2).click();
                childAmount --;
            }
        }
    }

    public void search(){
        driver.findElement(searchButton).click();
    }
}
