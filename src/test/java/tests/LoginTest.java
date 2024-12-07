package tests;

import DataProviders.LoginDataProvider;
import ObjectModels.LoginModel;
import com.opencsv.exceptions.CsvException;
import jakarta.xml.bind.JAXBException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

public class LoginTest extends BaseTest {

    // DataProvider updated to fetch data from the LoginSQLDataProvider in LoginDataProvider
    @DataProvider
    public Iterator<Object[]> loginDataProvider() throws SQLException, JAXBException, IOException, CsvException {
        return new LoginDataProvider().loginSQLDataProvider();
    }

    @Test(dataProvider = "loginDataProvider")
    public void testLogin(LoginModel loginModel) {
        String username = loginModel.getUsername();  // Get username from LoginModel
        String password = loginModel.getPassword();  // Get password from LoginModel
        String email = loginModel.getEmail();        // Get email from LoginModel

        getBrowser("chrome");  // Set up browser (or parameterize if needed)
        getBaseURL();

        navigateToURL();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);  // Log in using email and password from LoginModel

        // Check if the login was successful
        boolean isLoginSuccessful = loginPage.verifyLoginSuccessful(username);

        if (isLoginSuccessful) {
            // If login is successful, assert that the username is displayed correctly
            System.out.println("Login was successful.");
            Assert.assertTrue(isLoginSuccessful, "Test failed: Login was not successful.");
        } else {
            // If login was unsuccessful, verify that the error message is displayed
            System.out.println("Login failed. Checking error message.");
            boolean isErrorMessageDisplayed = loginPage.verifyLoginUnsuccessful();
            Assert.assertTrue(isErrorMessageDisplayed, "Test failed: Error message was not displayed.");
        }
    }
}
