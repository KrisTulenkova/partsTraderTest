package tests;

import helpers.DriverFactory;
import helpers.ParametersProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseConnection {

    /**
     * Browser driver.
     */
    protected WebDriver driver;

    /**
     * Suite setup.
     *
     * @throws IOException when config file is not available
     */
    @BeforeMethod
    public void setEnvironment() throws IOException {
        this.driver = DriverFactory.createDriver();
        String webUrl = ParametersProvider.readPropertiesFile().getProperty("webUrl");
        driver.get(webUrl);
    }

    /**
     * Make screenshot
     * Suite teardown
     */
    @AfterMethod
    public final void tearDown() throws IOException {
        driver.manage().window().fullscreen();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/test/java/screenshots/screenshot.png"));
        driver.quit();
    }
}
