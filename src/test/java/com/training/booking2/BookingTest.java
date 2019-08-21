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

        Thread.sleep(2000);

//        WebDriverWait ewait = new WebDriverWait(getDriver(),10);
//        ewait.until(ExpectedConditions.titleContains("Book your hotel now!"));

        OptionsPage optionsPage = new OptionsPage(getDriver());
        optionsPage.reserve();

        WebDriverWait ewait3 = new WebDriverWait(getDriver(),10);
        ewait3.until(ExpectedConditions.titleContains("Your Details"));

        PaymentPage paymentPage = new PaymentPage(getDriver());
        paymentPage.confirmHotel();

    }
}
