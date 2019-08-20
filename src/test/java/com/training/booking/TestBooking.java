package com.training.booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBooking extends BaseTest{

    private WebDriver driver;
    BookingPage bookingPage;
    OptionsPage optionsPage;

    @BeforeTest
    public void setUp(){
        bookingPage = new BookingPage(driver);
        driver = bookingPage.chromeDriverConnection();
        bookingPage.visit("https://www.booking.com/");
    }

    @Test
    public void test() throws InterruptedException {
        bookingPage.setDestination("Chile");
        bookingPage.setBookingDate();
        bookingPage.setChildAmount();

        bookingPage.search();

        WebDriverWait ewait = new WebDriverWait(driver,10);
        ewait.until(ExpectedConditions.titleContains("Book your hotel now!"));

        optionsPage = new OptionsPage(driver);
        optionsPage.reserve();
    }
}
