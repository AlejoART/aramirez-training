package com.training.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingPage extends BasePage {

    //locators here
    By accomodationLinkTextLocator = By.linkText("Accommodations");
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
        type(destination, searchBoxLocator);
    }
    public void setBookingDate(){
        findElement(calendar).click();
        findElement(checkIn).click();
        findElement(checkOut).click();
    }

    public int childAmount(){
        List<WebElement> spans = findElements(amounts);
        return Integer.parseInt(getText(spans.get(1)));
    }

    public void setChildAmount(){
        findElement(guestBoxToogle).click();
        int childAmount = childAmount();
        List <WebElement> setters = findElements(amountsSetters);
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
        findElement(searchButton).click();
    }
}