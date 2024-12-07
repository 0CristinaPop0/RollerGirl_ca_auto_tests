package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id='inputEmail']")  // Email input field
    private WebElement emailInput;

    @FindBy(id = "inputPassword")  // Password input field
    private WebElement passInput;

    @FindBy(xpath = "//*[@id='loginModules']/div/div[1]/div/div/form/p/button")  // Login button
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"bodyWrapper\"]/div[2]/div[1]/nav[2]/div/div/ul[2]/li[1]/a/span[2]")  // Username link (if logged in)
    private WebElement userName;

    @FindBy(xpath = "//*[@id='bodyContent']/div[2]")  // Invalid login error message
    private WebElement invalidLoginErrorMessage;

    @FindBy(xpath = "//*[@id=\"bodyWrapper\"]/div[2]/div[1]/nav[2]/div/div/ul[2]/li[1]/a/span[2]")  // My Account button
    private WebElement myAccountButton;

    @FindBy(xpath = "//*[@id=\"bodyWrapper\"]/div[2]/div[1]/nav[2]/div/div/ul[2]/li[1]/ul/li[1]/a")  // Log In button
    private WebElement logInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to perform login action
    public void login(String email, String password) {
        System.out.println("Navigating to 'My Account' section...");
        waitUntilElementVisible(myAccountButton);
        myAccountButton.click();

        System.out.println("Clicking 'Log In' button...");
        waitUntilElementVisible(logInButton);
        logInButton.click();

        System.out.println("Entering email: " + email);
        waitUntilElementVisible(emailInput);
        emailInput.clear();
        emailInput.sendKeys(email);

        System.out.println("Entering password: " + password);
        waitUntilElementVisible(passInput);
        passInput.clear();
        passInput.sendKeys(password);

        System.out.println("Clicking 'Login' button to submit the form...");
        waitUntilElementVisible(loginButton);
        loginButton.click();
    }

    // Method to verify if login is unsuccessful by checking if the error message appears
    public boolean verifyLoginUnsuccessful() {
        try {
            System.out.println("Checking if invalid login error message is displayed...");
            waitUntilElementVisible(invalidLoginErrorMessage);  // Wait for error message element to be visible
            boolean isErrorVisible = invalidLoginErrorMessage.isDisplayed();  // Check if error message is displayed
            if (isErrorVisible) {
                System.out.println("Login unsuccessful! Error message displayed.");
            }
            return isErrorVisible;
        } catch (Exception e) {
            System.out.println("No error message displayed. Proceeding to verify login success.");
            return false;  // If error message is not found, assume the login was not unsuccessful
        }
    }

    // Method to verify if login is successful by checking if the username appears
    public boolean verifyLoginSuccessful(String username) {
        try {
            System.out.println("Verifying login success by checking for username display...");
            waitUntilElementVisible(userName);  // Wait for the username link (anchor tag) to be visible

            // Get the displayed username (text) from the userName WebElement
            String actualUsername = userName.getText().trim();  // Remove unnecessary spaces or newlines

            // Log the actual and expected username for debugging
            System.out.println("Actual username displayed: " + actualUsername);
            System.out.println("Expected username: " + username);

            // Check if the username matches the expected value
            if (actualUsername.equals(username)) {
                System.out.println("Login successful! Username is displayed: " + actualUsername);
                return true;  // Login is successful, stop further checks
            } else {
                System.out.println("Login failed. Expected username: " + username + " but found: " + actualUsername);
                return false;
            }
        } catch (Exception e) {
            System.out.println("Login failed. Username element not found.");
            return false;  // If username element is not found, login was not successful
        }
    }

}
