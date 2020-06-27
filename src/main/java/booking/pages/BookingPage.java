package booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BookingPage extends BasePage {

    private By searchBoxLocator = By.id("ss");

    private By calendar= By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/span");
    private By checkIn = By.cssSelector("td[data-date='2019-09-23']");
    private By checkOut = By.cssSelector("td[data-date='2019-09-27']");

    private By guestsBox = By.cssSelector("span[class=xp__guests__count]");
    private By guestBoxToogle = By.xpath("//*[@id=\"xp__guests__toggle\"]");
    private By guestContainer = By.xpath("//*[@id=\"xp__guests__inputs-container\"]");
    private By amounts = By.cssSelector("span[class='bui-stepper__display']");
    private By amountsSetters = By.cssSelector("span[class='bui-button__text']");
    private By searchButton = By.cssSelector("button[data-sb-id=\"main\"]");

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public void setDestination(String destination){
        type(destination,searchBoxLocator);
    }
    public void setBookingDate(){
        click(calendar);
        click(checkIn);
        click(checkOut);
    }

    public int childAmount(){
        List<WebElement> spans;
        spans = findElements(amounts);
        return Integer.parseInt(getText(spans.get(1)));
    }

    public void setChildAmount(){
        click(guestBoxToogle);
        int childAmount = childAmount();
        List <WebElement> setters = findElements(amountsSetters);
        if(childAmount == 0){
            click(setters.get(3));
        }else{
            while(childAmount > 1){
                click(setters.get(2));
                childAmount --;
            }
        }
    }

    public void search(){
        click(searchButton);
    }
}
