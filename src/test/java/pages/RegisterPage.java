package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class RegisterPage extends BasePage {

    // Locators for registration form elements
    private final By firstNameField = By.id("inputFirstName");
    private final By lastNameField = By.id("inputLastName");
    private final By emailField = By.id("inputEmail");
    private final By streetField = By.id("inputStreet");
    private final By cityField = By.id("inputCity");
    private final By postalCodeField = By.id("inputZip");
    private final By stateField = By.id("inputState");
    private final By countryField = By.id("inputCountry");  // Country dropdown
    private final By telephoneField = By.id("inputTelephone");
    private final By passwordField = By.id("inputPassword");
    private final By confirmPasswordField = By.id("inputConfirmation");
    private final By errorMessage = By.xpath("//*[@id=\"bodyContent\"]/div[2]");
    private final By successMessage = By.id("successMessage");
    private final By registerButton = By.xpath("//*[@id=\"bodyWrapper\"]/div[2]/div[1]/nav[2]/div/div/ul[2]/li[1]/ul/li[2]/a");  // Registration button
    private final By accountButton = By.xpath("//*[@id=\"bodyWrapper\"]/div[2]/div[1]/nav[2]/div/div/ul[2]/li[1]/a");  // My Account button
    private final By continueButton = By.xpath("//*[@id=\"bodyContent\"]/form/div/div[5]/div/button");  // Continue button after registration

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Method to navigate to the Register page
    public void navigateToRegisterPage() {
        System.out.println("Attempting to click 'accountButton'.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for 'accountButton' to be clickable and click it
        WebElement accountBtn = wait.until(ExpectedConditions.elementToBeClickable(accountButton));
        accountBtn.click();
        System.out.println("'accountButton' clicked.");

        System.out.println("Attempting to click 'registerButton'.");
        // Wait for 'registerButton' to be clickable and click it
        WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerBtn.click();
        System.out.println("'registerButton' clicked.");
    }

    // Method to enter First Name
    public void enterFirstName(String firstName) {
        System.out.println("Entering First Name: " + firstName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        element.clear();
        element.sendKeys(firstName);
    }

    // Method to enter Last Name
    public void enterLastName(String lastName) {
        System.out.println("Entering Last Name: " + lastName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        element.clear();
        element.sendKeys(lastName);
    }

    // Method to enter Email
    public void enterEmail(String email) {
        System.out.println("Entering Email: " + email);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        element.clear();
        element.sendKeys(email);
    }

    // Method to enter Street
    public void enterStreet(String street) {
        System.out.println("Entering Street: " + street);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(streetField));
        element.clear();
        element.sendKeys(street);
    }

    // Method to enter City
    public void enterCity(String city) {
        System.out.println("Entering City: " + city);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cityField));
        element.clear();
        element.sendKeys(city);
    }

    // Method to enter Postal Code
    public void enterPostalCode(String postalCode) {
        System.out.println("Entering Postal Code: " + postalCode);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField));
        element.clear();
        element.sendKeys(postalCode);
    }

    // Method to enter State
    public void enterState(String state) {
        System.out.println("Entering State: " + state);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(stateField));
        element.clear();
        element.sendKeys(state);
    }

    // Method to handle the dropdown selection for Country
    public void enterCountry(String country) {
        System.out.println("Selecting Country: " + country);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(countryField));

        // Use Select class to interact with the dropdown
        Select select = new Select(element);
        select.selectByVisibleText(country);  // Select the country by visible text
        System.out.println("Country selected: " + country);
    }

    // Method to enter Telephone
    public void enterTelephone(String telephone) {
        System.out.println("Entering Telephone: " + telephone);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(telephoneField));
        element.clear();
        element.sendKeys(telephone);
    }

    // Method to enter Password
    public void enterPassword(String password) {
        System.out.println("Entering Password.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        element.clear();
        element.sendKeys(password);
    }

    // Method to enter Confirm Password
    public void enterConfirmPassword(String confirmPassword) {
        System.out.println("Entering Confirm Password.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField));
        element.clear();
        element.sendKeys(confirmPassword);
    }

    // Method to submit the registration form
    public void submit() {
        System.out.println("Attempting to click 'continueButton'.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        element.click();
        System.out.println("'continueButton' clicked.");
    }

    // Method to check if error message is displayed
    public boolean isErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return element.isDisplayed();
    }

    // Method to verify registration success
    public boolean verifyRegistrationSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return element.isDisplayed();
    }
}
