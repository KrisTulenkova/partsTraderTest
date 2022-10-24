package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver getDriver() {
        return driver;
    }

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
    public HomePage(final WebDriver webDriver) throws IllegalStateException {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='Search']")
    WebElement searchInput;

    @FindBy(xpath = "//*[@id='searchbox']/button")
    WebElement btnSubmitSearch;

    /**
     * Search method
     *
     * @param keyword to search
     */
    public final SearchPage search(String keyword) {
        searchInput.sendKeys(keyword);
        btnSubmitSearch.click();
        return new SearchPage(driver);
    }

}
