package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ScrollPage;
import testingData.StandardData;


public class ScrollTest extends BaseTestClass {

    WebDriver driver;
    String text;

    @BeforeMethod
    public void setUpTest() {
        driver = setUpDriver();
        text = StandardData.SCROLL_TEXT;
    }

    @Test
    public void TC07() {
        ScrollPage scrollPage = new ScrollPage(driver);

        scrollPage.open();
// scroll to page named 'Home Real Estate'
        //scrollPage.scrollToHomeRealEstate();
        scrollPage.scrollToBottom();
// hover over banner and click on 'More' after appearing and check is the banner expanded
        scrollPage.hoverHomeRealEstate();
        scrollPage.clickMore();
// click on banner and go to the new page
        scrollPage.clickToNewPage();
// click on Real Estate link and open new page and search word "office"
        scrollPage.clickRealEstate();
        scrollPage.enterSearchText(text);
        scrollPage.pressEnter();
// sort by Pages - Newest, after that check first and last page titles and total count of pages as well
        scrollPage.clickPageTab();
        scrollPage.hoverDropdown().selectNewest();
        scrollPage.firstPageTitle();
        scrollPage.lastPageTitle();
        scrollPage.countListSize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){ quitDriver(driver);
    }
}
