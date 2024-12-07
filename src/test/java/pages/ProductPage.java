package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Locators for the shop button, "All Skates" category, and product link
    private final By shopButton = By.xpath("//*[@id=\"shopmenu\"]");
    private final By allSkates = By.xpath("//*[@id=\"rgshop\"]/div/ul/li[1]/a");
    private final By productLink = By.xpath("//*[@id=\"products\"]/div[3]/div/div/h2/a");
    private final By sizingTool = By.xpath("//*[@id=\"sizingwizard\"]/h4");
    private final By sizingToolShoe = By.cssSelector("#ssize");
    private final By sizeMeButton = By.xpath("//*[@id=\"calcbutton\"]/input");
    private final By sizingResults = By.xpath("//*[@id=\"result\"]");

    // Method to click on the shop button
    public void clickShopButton() {
        System.out.println("Clicking on the Shop button.");
        WebElement shopButtonElement = driver.findElement(shopButton);
        shopButtonElement.click();
        System.out.println("Shop button clicked.");
    }

    // Method to click on the "All Skates" category
    public void clickAllSkates() {
        System.out.println("Clicking on the 'All Skates' category.");
        WebElement allSkatesElement = driver.findElement(allSkates);
        allSkatesElement.click();
        System.out.println("'All Skates' category clicked.");
    }

    // Method to click on the product link
    public void clickProductLink() {
        System.out.println("Clicking on the product link.");
        WebElement productLinkElement = driver.findElement(productLink);
        productLinkElement.click();
        System.out.println("Product link clicked.");
    }

    // Method to perform the full sequence: Click shop button, then click All Skates, and then click a product link
    public void clickOnSkateProduct() {
        System.out.println("Starting to navigate to a product page.");
        clickShopButton();  // Click on the shop button
        clickAllSkates();   // Click on "All Skates" category
        clickProductLink(); // Click on a product link
        System.out.println("Product page navigation completed.");
    }

    // Method to check the sizing tool, update the shoe size, click the button, and validate results
    public void checkAndUseSizingTool(int shoeSize) {
        System.out.println("Checking if the sizing tool is available.");

        // Check if the sizing tool is visible
        WebElement sizingToolElement = driver.findElement(sizingTool);
        if (sizingToolElement != null && sizingToolElement.isDisplayed()) {
            System.out.println("Sizing tool found on the page.");

            // Adjust the shoe size (parameterized)
            WebElement sizingToolShoeElement = driver.findElement(sizingToolShoe);
            sizingToolShoeElement.clear(); // Clear the existing value
            System.out.println("Setting shoe size to '" + shoeSize + "'.");
            sizingToolShoeElement.sendKeys(String.valueOf(shoeSize)); // Set the shoe size to the parameter value

            // Click the "Size Me" button
            WebElement sizeMeButtonElement = driver.findElement(sizeMeButton);
            sizeMeButtonElement.click();
            System.out.println("'Size Me' button clicked.");

            // Wait for the results to load (you can add a WebDriverWait here if necessary)
            // Get the value from the sizing result text area
            WebElement sizingResultsElement = driver.findElement(sizingResults);
            String resultsText = sizingResultsElement.getAttribute("value"); // Use getAttribute("value") to get textarea value
            System.out.println("Sizing results: " + resultsText);

            // If the results contain 'J', fail the test
            if (resultsText != null && resultsText.contains("J")) {
                System.out.println("ERROR: Sizing results contain 'J'. Test failed.");
                Assert.fail("Sizing results contain 'J'. Test failed.");
            } else {
                System.out.println("Sizing results do not contain 'J'. Test passed.");
            }
        } else {
            System.out.println("WARNING: Sizing tool not found on the page.");
        }
    }
}
