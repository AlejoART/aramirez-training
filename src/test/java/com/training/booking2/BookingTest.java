package com.training.booking2;

import com.training.booking2.OptionsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BookingTest extends BaseTest {

    @Test
    public void bookingTest() throws InterruptedException {
        BookingPage bookingPage = new BookingPage(getDriver());
        bookingPage.driver.get("https://www.booking.com/");

        bookingPage.setDestination("Chile");
        bookingPage.setBookingDate();
        bookingPage.setChildAmount();

        bookingPage.search();

        WebDriverWait ewait = new WebDriverWait(getDriver(),10);
        ewait.until(ExpectedConditions.titleContains("Book your hotel now!"));

        OptionsPage optionsPage = new OptionsPage(getDriver());
        optionsPage.reserve();

    }
}
