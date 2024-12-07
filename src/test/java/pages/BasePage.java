package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait longWait;

    // Constructor for BasePage, initializing the WebDriver and WebDriverWaits
    public BasePage(WebDriver driver) {
        this.driver = driver;

        // Initialize explicit waits with durations of 20 seconds and 40 seconds
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Default wait
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(40)); // Long wait for specific cases

        // Implicit wait globally, although it's recommended to use explicit waits for most cases
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); // Timeout for page load
    }

    // Method to wait until an element is visible (by locator)
    public WebElement waitUntilElementVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Method to wait until a WebElement is visible
    public void waitUntilElementVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /*Method to wait until a WebElement is clickable
    public void waitUntilElementClickable(WebElement element){
       wait.until(ExpectedConditions.elementToBeClickable(element));

     */

    // Method to wait until an alert is present
    public Alert waitUntilAlertIsPresent(){
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    // Method to get text from an alert
    public String getAlertText(Alert alert){
        return alert.getText();
    }


    // Method to check if an alert is closed
    public boolean isAlertClosed(){
        try {
            driver.switchTo().alert();
            return false; // Alert is not closed
        } catch (NoAlertPresentException e){
            return true; // Alert is closed
        }
    }
}
