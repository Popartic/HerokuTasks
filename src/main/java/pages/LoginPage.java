package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import testingData.StandardData;
import testingData.TimeDelay;

public class LoginPage extends BasePageClass{
    private final String loginURL = StandardData.LOGIN_URL;
    private final By usernameFieldLocator = By.xpath("//input[@name='username']");
    private final By passwordFieldLocator = By.xpath("//input[@name='password']");
    private final By loginButtonLocator = By.xpath("//i[text()=' Login']");
    private final By logoutButtonLocator = By.xpath("//i[text()=' Logout']");
    private final By loginMessageLocator = By.xpath("//div[@id='flash']");


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage open(){
        openUrl(loginURL);
        return this;
    }
    public LoginPage enterUsername(String username) {
        WebElement usernameField = waitForWebElementToBeVisible(usernameFieldLocator, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(usernameField, username);
        return this;
    }
    public LoginPage enterPassword(String password) {
        WebElement passwordField = waitForWebElementToBeVisible(passwordFieldLocator, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(passwordField, password);
        return this;
    }
    public LoginPage pressLogin(){
        click(loginButtonLocator);
        return this;
    }
    public LoginPage pressLogout(){
        click(logoutButtonLocator);
        return this;
    }
    public void assertElementTextEquals(String expectedText) {
        WebElement element = waitForWebElementToBeVisible(loginMessageLocator, TimeDelay.DELAY_3_SEC);
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, "Element text does not match expected value.");
        System.out.println(actualText);
    }
}
