package booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OptionsPage extends BasePage {
    private By reserveBtn = By.xpath("//*[@id=\"group_recommendation\"]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/a/span");
    private By hotelName = By.xpath("//*[@id=\"hp_hotel_name\"]");
    private By hotelPrice = By.cssSelector("div[class='bui-price-display__value prco-ltr-center-align-helper prco-font16-helper']");
    private By numbRooms = By.cssSelector("#hprt_nos_select_534593501_189325125_4_1_0");
    private By errorMsg = By.xpath("//*[@id=\"hprt-table\"]/tbody/tr/td[5]/div/div/div/p/span");

    public OptionsPage(WebDriver driver) {
        super(driver);
    }
    public void reserve() throws InterruptedException {

        WebDriverWait ewait2 = new WebDriverWait(driver, 10);
        ewait2.until(ExpectedConditions.elementToBeClickable(findElements(By.cssSelector("button[type='submit']")).get(2)));

        click(findElements(By.cssSelector("button[type='submit']")).get(2));

        WebDriverWait ewait = new WebDriverWait(driver, 10);
        ewait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));

        Select selectList = new Select(findElement(numbRooms));
        selectList.selectByValue("1");

        click(findElements(By.cssSelector("button[type='submit']")).get(2));
    }

    public String getHotelName() {
        return getText(hotelName);
    }

    public String getHotelPrice() {
        return getText(hotelPrice);
    }

}
