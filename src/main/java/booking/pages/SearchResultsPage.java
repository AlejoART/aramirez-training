package booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends BasePage {

    private By lowestPrice = By.partialLinkText("Price (lowest first)");
    private By availability = By.partialLinkText("See availability");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void checkAvailability() throws InterruptedException {
        click(lowestPrice);
        Thread.sleep(2000);
        //WebDriverWait ewait = new WebDriverWait(driver, 10);
        //ewait.until(ExpectedConditions.visibilityOfElementLocated(availability));

        click(availability);
    }
}
