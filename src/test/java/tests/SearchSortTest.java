package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchSortPage;

public class SearchSortTest extends BaseTest {

    @Test
    public void testSearchAndSortByPrice() {
        // Manually call setUp() to initialize the WebDriver
        setUp();  // Ensure WebDriver and basePage are initialized

        // Navigate to the URL (this uses the baseURL that was set in setUp())
        navigateToURL();

        // Initialize the SearchSortPage to perform actions on the page
        SearchSortPage searchSortPage = new SearchSortPage(driver);

        // Define the search query
        String query = "pink";

        // Perform the search and sort actions using the method from SearchSortPage
        searchSortPage.searchAndSortByPrice(query);

        // Verify that the 'Sort by' button's text has changed to show "Price" after the first click
        Assert.assertTrue(searchSortPage.isSortByPriceButtonClicked(), "Sort by button text does not indicate 'Price' was selected.");

        // Click the sort button again to open the dropdown and check for "Price+" in the dropdown
        searchSortPage.clickSortButton();

        // Verify that the 'Sort by' button's text has changed to "Price+" after second click (dropdown opened)
        Assert.assertTrue(searchSortPage.isSortByPriceButtonClicked(), "Sort by button text did not change to 'Price+' after second click.");
    }
}
