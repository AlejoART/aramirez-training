package com.training.booking2;

import com.training.booking2.OptionsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

        SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
        searchResultsPage.checkAvailability();
        switchToTab(2);
        Thread.sleep(2000);

//        WebDriverWait ewait = new WebDriverWait(getDriver(),10);
//        ewait.until(ExpectedConditions.titleContains("Book your hotel now!"));

        OptionsPage optionsPage = new OptionsPage(getDriver());
        Hotel hotel = new Hotel();
        hotel.setPrice(optionsPage.getHotelPrice());
        optionsPage.reserve();

        WebDriverWait ewait3 = new WebDriverWait(getDriver(),10);
        ewait3.until(ExpectedConditions.titleContains("Your Details"));

        PaymentPage paymentPage = new PaymentPage(getDriver());
        Assert.assertTrue(paymentPage.confirmHotel(hotel.getPrice()),"The information of the hotel doesn't match!");

    }
}
