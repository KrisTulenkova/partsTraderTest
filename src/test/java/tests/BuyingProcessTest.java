package tests;

import helpers.ParametersProvider;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class BuyingProcessTest extends BaseConnection {

    @Test(description = "‘Printed Summer Dress’ test")
    public final void totalPriceTest() throws IOException {
        String searchKeyWord = ParametersProvider.readPropertiesFile().getProperty("searchKeyWord");
        String expectedTotalPrice = ParametersProvider.readPropertiesFile().getProperty("expectedTotalPrice");
        String orderQuantity = ParametersProvider.readPropertiesFile().getProperty("orderQuantity");

        HomePage homePage = new HomePage(driver);
        String totalPriceActual = homePage.search(searchKeyWord)
                .sort()
                .selectItem()
                .changeOrderParam(orderQuantity)
                .goToCheckout().readingTotalPrice();
        assertEquals(expectedTotalPrice, totalPriceActual,
                "Expected total Price not equals actual");
    }
}
