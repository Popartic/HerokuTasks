package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckBoxTest extends BaseTestClass {

    WebDriver driver;
    String expectedStatus1;
    String expectedStatus2;

    @BeforeMethod
    public void setUpTest() {

        driver = setUpDriver();
        expectedStatus1 = "checked";
        expectedStatus2 = "unchecked";
    }

    @Test
    public void TC03() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
// proveriti trenutne statuse oba checkbox-a, da li su čekirani ili ne
        checkboxesPage.open();
        checkboxesPage.checkingBox1Status();
        checkboxesPage.checkingBox2Status();
// selektovati prvi checkbox i proveriti njegov status
        checkboxesPage.checkBox1();
        checkboxesPage.assertCheckbox1Status(expectedStatus1);
// skinuti selekciju sa drugog checkbox-a i proveriti status
        checkboxesPage.checkBox2();
        checkboxesPage.assertCheckbox2Status(expectedStatus2);
        }

        @AfterMethod(alwaysRun = true)
        public void tearDownTest () { quitDriver(driver);
        }
    }

