package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='pass']/../../button")
    private WebElement signInButton;

    @FindBy(id = "user")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passInput;

    @FindBy(xpath = "//h1[contains(text(),'Sign in')]")
    private WebElement pageIdentifier;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        System.out.println("Waiting for login page to load");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitUntilElementVisible(pageIdentifier);

        System.out.println("Entering username");
        this.enterUsername(username);
        this.enterPassword(password);
        this.submit();


    }

    public void enterUsername(String username) {
        waitUntilElementVisible(emailInput);
        System.out.println("Enter username: " + username);
        emailInput.clear();
        emailInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(passInput);
        System.out.println("Enter password: " + password);
        passInput.clear();
        passInput.sendKeys(password);
    }

    public void submit() {
        waitUntilElementVisible(signInButton);
        System.out.println("Click on the sign in button");
        signInButton.click();
    }

    public boolean verifyLoginSuccessful(String username) {
        String xpath = "//h1[contains(text(),'Welcome to web-stubs, " + username + "!')]";
        WebElement welcomeMessage = waitUntilElementVisible(By.xpath(xpath));
        System.out.println("Welcome message displayed " + welcomeMessage.getText());
        return welcomeMessage.isDisplayed();
    }

}

