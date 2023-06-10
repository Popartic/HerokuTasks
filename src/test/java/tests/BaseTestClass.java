package tests;

import org.openqa.selenium.WebDriver;
import utils.WebDriverUtils;

public class BaseTestClass {

    protected WebDriver setUpDriver(){
        return WebDriverUtils.setUpWebDriver();
    }
    protected void quitDriver(WebDriver driver){
        WebDriverUtils.driverExit(driver);
    }
}
