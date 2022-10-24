package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    /**
     * Browser driver.
     */
    private WebDriver driver;

    /**
     * Page object constructor.
     *
     * @param webDriver browser driver
     * @throws IllegalStateException if page is not open now
     */
    public CheckoutPage(final WebDriver webDriver) throws IllegalStateException {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "total_price")
    WebElement totalPrice;

    /**
     * Extract total price method
     */
    public final String readingTotalPrice() {
        return totalPrice.getText();
    }
}
