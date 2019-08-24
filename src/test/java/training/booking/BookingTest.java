package training.booking;

import booking.entities.Hotel;
import booking.pages.BookingPage;
import booking.pages.OptionsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import booking.pages.PaymentPage;
import booking.pages.SearchResultsPage;

public class BookingTest extends BaseTest {

    @Test
    public void bookingTest() throws InterruptedException {
        BookingPage bookingPage = new BookingPage(getDriver());

        bookingPage.setDestination("Chile");
        bookingPage.setBookingDate();
        bookingPage.setChildAmount();
        bookingPage.search();

        SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
        searchResultsPage.checkAvailability();
        switchToTab(2);

        WebDriverWait ewait2 = new WebDriverWait(getDriver(),10);
        ewait2.until(ExpectedConditions.titleContains("Chile - Booking.com"));

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
