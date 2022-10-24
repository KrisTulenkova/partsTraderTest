package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
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
    public ProductPage(final WebDriver webDriver) throws IllegalStateException {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "quantity_wanted")
    WebElement quantity;

    @FindBy(xpath = "//*[@id='group_1']/option[2]")
    WebElement selectSizeM;

    @FindBy(id = "color_15")
    WebElement selectColorGreen;

    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    WebElement btnAddToCart;

    /**
     * Change order quantity,size and color.
     * @param quantityChoose
     */
    public final CartPage changeOrderParam(String quantityChoose) {
        quantity.sendKeys(Keys.BACK_SPACE);
        quantity.sendKeys(quantityChoose);
        selectSizeM.click();
        selectColorGreen.click();
        btnAddToCart.click();
        return new CartPage(driver);
    }
}
