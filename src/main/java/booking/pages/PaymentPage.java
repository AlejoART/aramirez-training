package booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    private By checkInDate = By.xpath("//*[@id=\"fullwidth\"]/div[2]/div[1]/div[2]/ul/li[1]/div[2]/strong");
    private By checkOutDate = By.xpath("//*[@id=\"fullwidth\"]/div[2]/div[1]/div[2]/ul/li[2]/div[2]/strong");
    private By hotelPriceConf = By.cssSelector("span[class='bp_pricedetails_breakdown_price']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public Boolean confirmHotel(String hotelPrice) {
        return (getText(checkInDate).equals("Monday, September 23, 2019")
                && getText(checkOutDate).equals("Friday, September 27, 2019")
                && getText(hotelPriceConf).equals(hotelPrice));
    }
}
