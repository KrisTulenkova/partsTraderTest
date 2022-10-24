package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

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
    public SearchPage(final WebDriver webDriver) throws IllegalStateException {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='selectProductSort']/option[2]")
    WebElement selectSortValue;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]")
    WebElement selectItem;

    /**
     * Lowest price sort method
     */
    public final SearchPage sort() {
        selectSortValue.click();
        return this;
    }

    /**
     * Select first item
     */
    public final ProductPage selectItem() {
        selectItem.click();
        return new ProductPage(driver);
    }
}
