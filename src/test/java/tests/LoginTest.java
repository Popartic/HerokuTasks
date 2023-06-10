package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import testingData.StandardData;

public class LoginTest extends BaseTestClass {

    WebDriver driver;
    String username;
    String password;
    String invalidUsername;
    String invalidPassword;
    String expectedLoginMessage;
    String expectedLogoutMessage;
    String invalidUsernameMessage;
    String invalidPasswordMessage;



    @BeforeMethod
    public void setUpTest(){
        driver = setUpDriver();
        username = StandardData.USERNAME;
        password = StandardData.PASSWORD;
        invalidUsername = StandardData.USERNAME_INVALID;
        invalidPassword = StandardData.PASSWORD_INVALID;
        expectedLoginMessage = StandardData.LOGIN_MESSAGE;
        expectedLogoutMessage = StandardData.LOGOUT_MESSAGE;
        invalidUsernameMessage = StandardData.INVALID_USERNAME_MESSAGE;
        invalidPasswordMessage = StandardData.INVALID_PASSWORD_MESSAGE;
    }
    @Test
    public void TC01() {
        LoginPage login = new LoginPage(driver);
// open login page, enter valid username and password, successfully login and checking login message
        login.open();
        login.enterUsername(username);
        login.enterPassword(password);
        login.pressLogin();
        login.assertElementTextEquals(expectedLoginMessage);
// logout and checking the logout message
        login.pressLogout();
        login.assertElementTextEquals(expectedLogoutMessage);
// login with invalid username and valid password, checking login message
        login.enterUsername(invalidUsername);
        login.enterPassword(password);
        login.pressLogin();
        login.assertElementTextEquals(invalidUsernameMessage);
// login with valid username and invalid password, checking login message
        login.enterUsername(username);
        login.enterPassword(invalidPassword);
        login.pressLogin();
        login.assertElementTextEquals(invalidPasswordMessage);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }
}
