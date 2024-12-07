package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import pages.BasePage;
import utils.BrowserUtils;
import utils.ConfigUtils;
import utils.ConstantUtils;

public class BaseTest {
    protected WebDriver driver;
    protected String baseURL;
    protected BasePage basePage;
    protected Alert alert;

    // Method to initialize the browser with a specific browser type
    public void getBrowser(String browserName) {
        driver = BrowserUtils.getDriver(browserName);
    }

    // Method to initialize the browser with the default config
    public void getBrowser() {
        String browserName = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "browser", "chrome");
        System.out.println("Load browser type: " + browserName);
        driver = BrowserUtils.getDriver(browserName);
        basePage = new BasePage(driver);
    }

    // Method to initialize the browser with environment-based configuration
    public void getBrowserWithEnv() {
        String browserName = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "browser", "chrome");
        String environment = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "environment", "local");
        System.out.println("Load browser type: " + browserName);
        driver = BrowserUtils.getDriver(browserName, environment);
        basePage = new BasePage(driver);
    }

    // Setting up the browser and base URL for the test
    public void setUp() {
        getBaseURL();
        getBrowser();
    }

    // Method to close the browser at the end of the test
    void closeBrowserAtEnd() {
        if (driver != null) {
            System.out.println("Close browser at the end of test");
            driver.quit(); // Close all browser windows and end the session
        }
    }

    // Clean up method after each test method
    @AfterMethod
    public void cleanUpAfterMethod() {
        closeBrowserAtEnd();
    }

    // Get the base URL from the config file
    public void getBaseURL() {
        getBaseURL(ConstantUtils.DEFAULT_CONFIG_FILE);
    }

    // Get the base URL from a specific config file
    public void getBaseURL(String configFileName) {
        baseURL = ConfigUtils.readGenericElementFromConfig(configFileName, "base.url");
    }

    // Navigate to a specific URL (append the path to the base URL)
    public void navigateToURL() {
        System.out.println("Open next url:" + baseURL);
        driver.navigate().to(baseURL);
    }

}
