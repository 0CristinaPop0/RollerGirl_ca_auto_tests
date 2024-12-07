package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage {

    // WebElements on the Shopping Cart Page

    @FindBy(id = "cartItems")
    private WebElement cartItemsList;  // A list of all items in the cart (could be a table or div)

    @FindBy(xpath = "//span[@class='cart-total']")
    private WebElement totalPriceLabel;  // Label showing the total price of the items in the cart

    @FindBy(xpath = "//button[@class='remove-item']")
    private WebElement removeItemButton;  // Button to remove an item from the cart

    @FindBy(id = "emptyCartMessage")
    private WebElement emptyCartMessage;  // Message displayed when the cart is empty

    @FindBy(id = "checkoutButton")
    private WebElement checkoutButton;  // Button to proceed to checkout

    @FindBy(id = "cartItemQuantity")
    private WebElement itemQuantityField;  // Input to change the quantity of an item

    @FindBy(id = "updateCartButton")
    private WebElement updateCartButton;  // Button to update the cart after changing quantities

    @FindBy(id = "discountCodeInput")
    private WebElement discountCodeInput;  // Input field to enter discount codes

    @FindBy(id = "applyDiscountButton")
    private WebElement applyDiscountButton;  // Button to apply discount code

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with elements on the Shopping Cart Page

    public boolean isCartEmpty() {
        return emptyCartMessage.isDisplayed();
    }

    public boolean isTotalPriceCorrect(double expectedPrice) {
        double totalPrice = Double.parseDouble(totalPriceLabel.getText().replace("$", ""));
        return totalPrice == expectedPrice;
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(checkoutButton);
        checkoutButton.click();
    }

    public void removeItemFromCart() {
        waitUntilElementVisible(removeItemButton);
        removeItemButton.click();
    }

    public void updateItemQuantity(int newQuantity) {
        waitUntilElementVisible(itemQuantityField);
        itemQuantityField.clear();
        itemQuantityField.sendKeys(String.valueOf(newQuantity));
        waitUntilElementVisible(updateCartButton);
        updateCartButton.click();
    }

    public void applyDiscountCode(String discountCode) {
        waitUntilElementVisible(discountCodeInput);
        discountCodeInput.clear();
        discountCodeInput.sendKeys(discountCode);
        waitUntilElementVisible(applyDiscountButton);
        applyDiscountButton.click();
    }

    public boolean isItemInCart(String productName) {
        WebElement productElement = cartItemsList.findElement(By.xpath("//div[contains(text(),'" + productName + "')]"));
        return productElement.isDisplayed();
    }

    public void waitForCartToUpdate() {
        waitUntilElementVisible(totalPriceLabel);
    }
}
