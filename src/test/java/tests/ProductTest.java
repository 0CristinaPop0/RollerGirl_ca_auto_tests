package tests;

import org.testng.annotations.Test;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    public void testPositiveSizingTool() {
        // Initialize the WebDriver
        setUp();

        // Navigate to the URL (make sure this is the page where the shop button is visible)
        navigateToURL();

        // Initialize the ProductPage object
        ProductPage productPage = new ProductPage(driver);

        // Perform the sequence of actions: navigate through shop, All Skates, and select a product
        productPage.clickOnSkateProduct();

        // Positive Test: Use the sizing tool with size "4"
        System.out.println("Positive Test - Entering Size: 4");
        productPage.checkAndUseSizingTool(4); // Size 4 (positive test)

        // Optionally, verify other aspects of the page (e.g., check URL, page title, etc.)
        // For example, you could verify that the page title contains 'Skates'
        // Assert.assertTrue(driver.getTitle().contains("Skates"), "Page title doesn't contain 'Skates'.");

        // Clean up (if necessary, e.g., close the driver after the test)
        // driver.quit();
    }

    @Test
    public void testNegativeSizingTool() {
        // Initialize the WebDriver
        setUp();

        // Navigate to the URL (make sure this is the page where the shop button is visible)
        navigateToURL();

        // Initialize the ProductPage object
        ProductPage productPage = new ProductPage(driver);

        // Perform the sequence of actions: navigate through shop, All Skates, and select a product
        productPage.clickOnSkateProduct();

        // Negative Test: Use the sizing tool with size "-1"
        System.out.println("Negative Test - Entering Size: -1");
        productPage.checkAndUseSizingTool(-1); // Size -1 (negative test)

        // Clean up (if necessary, e.g., close the driver after the test)
        // driver.quit();
    }
}
