package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DOMPage;

public class DOMTest extends BaseTestClass {

    WebDriver driver;

    @BeforeMethod
    public void setUpTest() {
        driver = setUpDriver();
    }

    @Test
    public void TC02() {
        DOMPage domPage = new DOMPage(driver);
//open DOM page and checking and print elements form 6th row
        domPage.open();
        domPage.rowSIX();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }
}