package tests;

import DataProviders.RegisterDataProvider;
import ObjectModels.RegisterModel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.io.IOException;
import java.util.Iterator;

public class RegisterTest extends BaseTest {

    // Data provider for registration test data (from JSON file)
    @DataProvider(name = "registerJsonDataProvider")
    public Iterator<Object[]> registerJsonDataProvider() throws IOException {
        System.out.println("Fetching registration data from JSON.");
        return new RegisterDataProvider().registerJsonDataProvider();  // Ensure this returns an Iterator of Object arrays
    }

    // Test method using data from DataProvider

    @Test(dataProvider = "registerJsonDataProvider")
    public void testRegister(RegisterModel registerModel) {
        System.out.println("Starting registration test for email: " + registerModel.getEmail());

        // Get the browser and base URL (use inherited methods from BaseTest)
        getBrowser("chrome");
        System.out.println("Browser set to Chrome.");

        getBaseURL();
        navigateToURL();
        System.out.println("Navigated to URL: " + baseURL);

        // Initialize RegisterPage and interact with the registration form
        RegisterPage registerPage = new RegisterPage(driver);
        System.out.println("Initialized RegisterPage.");

        // Navigate to the Register Page by clicking the 'My Account' and 'Register' buttons
        registerPage.navigateToRegisterPage();
        System.out.println("Navigated to Register Page.");

        // Fill in the registration form with provided data
        registerPage.enterFirstName(registerModel.getFirstName());
        System.out.println("Entered First Name: " + registerModel.getFirstName());

        registerPage.enterLastName(registerModel.getLastName());
        System.out.println("Entered Last Name: " + registerModel.getLastName());

        registerPage.enterEmail(registerModel.getEmail());
        System.out.println("Entered Email: " + registerModel.getEmail());

        registerPage.enterPassword(registerModel.getPassword());
        System.out.println("Entered Password.");

        registerPage.enterConfirmPassword(registerModel.getConfirmPassword());
        System.out.println("Entered Confirm Password.");

        registerPage.enterStreet(registerModel.getStreet());
        System.out.println("Entered Street: " + registerModel.getStreet());

        registerPage.enterCity(registerModel.getCity());
        System.out.println("Entered City: " + registerModel.getCity());

        registerPage.enterPostalCode(registerModel.getPostalCode());
        System.out.println("Entered Postal Code: " + registerModel.getPostalCode());

        registerPage.enterState(registerModel.getState());
        System.out.println("Entered State: " + registerModel.getState());

        registerPage.enterCountry(registerModel.getCountry());
        System.out.println("Entered Country: " + registerModel.getCountry());

        registerPage.enterTelephone(registerModel.getTelephone());
        System.out.println("Entered Telephone: " + registerModel.getTelephone());

        // Submit the registration form
        registerPage.submit();
        System.out.println("Form submitted.");

        // Handle the error message or successful registration
        if (!registerModel.getLoginErr().isEmpty()) {
            // If there's an expected error message, verify it
            System.out.println("Expected error message: " + registerModel.getLoginErr());
            Assert.assertTrue(registerPage.isErrorMessageDisplayed(), "Expected error message not displayed.");
            System.out.println("Error message displayed as expected.");
        } else {
            // If no error message expected, verify registration success
            System.out.println("No error expected. Verifying successful registration.");
            Assert.assertTrue(registerPage.verifyRegistrationSuccess(), "Registration was not successful.");
            System.out.println("Registration was successful.");
        }
    }


}
