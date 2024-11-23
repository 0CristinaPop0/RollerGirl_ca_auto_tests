package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait longWait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));//explicit wait
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(40));//explicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //implicit wait
    }
    public WebElement waitUntilElementVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilElementVisible(WebElement element){
         wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilElementClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Alert waitUntilAlertIsPresent(){
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    public String getAlertText(Alert alert){
        return alert.getText();
    }

    public void acceptAlert(Alert alert) {
        //press the ok button from alert
        alert.accept();
    }

        public void acceptAlert(Alert alert, String response){

            alert.sendKeys(response);
            alert.accept();

        }

    public void cancelAlert(Alert alert) {
        //press the ok button from alert
        alert.dismiss();
    }

    public boolean isAlertClosed(){

        try {
            driver.switchTo().alert();
            return false;
        } catch (NoAlertPresentException e){
            return true;
        }
    }

}

