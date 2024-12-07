package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void testItemAddedToCart() {
        // Navigate to the shopping cart page
        driver.get("https://www.example.com/cart");

        ShoppingCartPage cartPage = new ShoppingCartPage(driver);

        // Verify that the cart contains a specific item
        Assert.assertTrue(cartPage.isItemInCart("Super Skates 5000"), "Item is not in the cart.");
    }

    @Test
    public void testRemoveItemFromCart() {
        // Navigate to the shopping cart page
        driver.get("https://www.example.com/cart");

        ShoppingCartPage cartPage = new ShoppingCartPage(driver);

        // Remove an item from the cart
        cartPage.removeItemFromCart();

        // Verify that the cart is now empty
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty after removing item.");
    }

    @Test
    public void testUpdateItemQuantity() {
        // Navigate to the shopping cart page
        driver.get("https://www.example.com/cart");

        ShoppingCartPage cartPage = new ShoppingCartPage(driver);

        // Update the quantity of an item
        cartPage.updateItemQuantity(3);

        // Wait for the cart to update and check the new total price
        cartPage.waitForCartToUpdate();

        // Verify that the total price is correct
        Assert.assertTrue(cartPage.isTotalPriceCorrect(299.97), "Total price is not correct after updating quantity.");
    }

    @Test
    public void testApplyDiscountCode() {
        // Navigate to the shopping cart page
        driver.get("https://www.example.com/cart");

        ShoppingCartPage cartPage = new ShoppingCartPage(driver);

        // Apply a discount code
        cartPage.applyDiscountCode("SAVE20");

        // Verify that the total price reflects the discount
        Assert.assertTrue(cartPage.isTotalPriceCorrect(239.97), "Total price is incorrect after applying discount.");
    }

    @Test
    public void testProceedToCheckout() {
        // Navigate to the shopping cart page
        driver.get("https://www.example.com/cart");

        ShoppingCartPage cartPage = new ShoppingCartPage(driver);

        // Proceed to checkout
        cartPage.proceedToCheckout();

        // Verify that the user is redirected to the checkout page
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), "User is not redirected to the checkout page.");
    }
}
