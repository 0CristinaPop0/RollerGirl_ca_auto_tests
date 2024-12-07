package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchSortPage extends BasePage {

    public SearchSortPage(WebDriver driver) {
        super(driver);
    }

    // Locators for the search bar and sorting options
    private final By searchBar = By.xpath("//*[@id=\"bodyWrapper\"]/div[2]/div[1]/div[2]/div[1]/form/div/input");
    private final By searchButton = By.id("search-button");  // Assuming this is the button to click for search
    private final By sortBy = By.xpath("//*[@id=\"bodyContent\"]/div[2]/div[1]/div[1]/div[1]/button");
    private final By byPrice = By.xpath("//*[@id=\"bodyContent\"]/div[2]/div[1]/div[1]/div[1]/ul/li[3]/a");
    private final By sortByButtonText = By.xpath("//*[@id=\"bodyContent\"]/div[2]/div[1]/div[1]/div[1]/button"); // Same as sortBy

    // Search functionality
    public void enterSearchQuery(String query) {
        // Locate the search bar, type the query, and press "Enter"
        WebElement searchField = driver.findElement(searchBar);
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);  // This simulates pressing the "Enter" key
    }



    // Sorting functionality
    public void clickSortButton() {
        WebElement sortButtonElement = driver.findElement(sortBy);
        sortButtonElement.click();
    }

    public void selectSortByPrice() {
        WebElement priceSortOption = driver.findElement(byPrice);
        priceSortOption.click();
    }

    // Verify that the text of the "Sort by" button has changed to reflect that "Price" is selected
    public boolean isSortByPriceButtonClicked() {
        WebElement sortButton = driver.findElement(sortByButtonText);  // Use the initialized locator
        String buttonText = sortButton.getText();  // Get the current text of the button
        return buttonText.contains("Price+");  // Verify if the text contains "Price+"
    }

    // You can chain the actions into one method if you like
    public void searchAndSortByPrice(String query) {
        enterSearchQuery(query);   // Step 1: Enter search query and press enter
        clickSortButton();         // Step 2: Click the sort button
        selectSortByPrice();       // Step 3: Click "By Price" to sort
    }
}
