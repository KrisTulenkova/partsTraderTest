package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
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
    public CartPage(final WebDriver webDriver) throws IllegalStateException {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[title='Proceed to checkout']")
    WebElement btnCheckout;

    /**
     * Processing to checkout method
     */
    public final CheckoutPage goToCheckout() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(btnCheckout)).click();
        return new CheckoutPage(driver);
    }
}
