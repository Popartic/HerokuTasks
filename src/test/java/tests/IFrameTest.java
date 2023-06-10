package tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.IFramePage;
import testingData.StandardData;

public class IFrameTest extends BaseTestClass {
    WebDriver driver;
    String expectedTextHeading;
    String expectedTextFormating;
    String expectedColour;
    String expectedAlign;

    @BeforeMethod
    public void setUpTest(){
        driver = setUpDriver();
        expectedTextHeading = StandardData.IFRAME_SB_HEADING;
        expectedTextFormating = StandardData.IFRAME_SB_FORMAT;
        expectedColour = StandardData.IFRAME_RGB;
        expectedAlign = StandardData.IFRAME_ALIGN;

    }

    @Test
    public void TC05() {
        IFramePage iFramePage = new IFramePage(driver);

// open File menu, choose New Document, check is the text field empty
        iFramePage.open();
        iFramePage.openNewDocument();
        iFramePage.switchToEditArea();
        iFramePage.isTextFieldEmpty();
// in text area type "iFrame Test" and format it as Heading3, check is status bar value H3
        iFramePage.enterTextInEditor();
        iFramePage.selectTextInEditor();
        iFramePage.switchToMainArea();
        iFramePage.selectPharagraph().selectHeadings().selectHeadings3();
        iFramePage.assertElementTextEquals(expectedTextHeading);
// go to new line type "Paragraph text" format it in paragraph , bold "text" and check is status bar P»STRONG
        iFramePage.switchToEditArea();
        iFramePage.goToNewLine();
        iFramePage.enterNewText();
        iFramePage.doubleClick();
        iFramePage.switchToMainArea();
        iFramePage.selectBold();
        iFramePage.assertElementTextEquals(expectedTextFormating);
// select all text and choose option Align Center
        iFramePage.switchToEditArea();
        iFramePage.selectAll();
        iFramePage.switchToMainArea();
        iFramePage.centerAlign();
        iFramePage.switchToEditArea();
        iFramePage.assertTextAlignPosition(expectedAlign);
// switch color to red with option Format > Text Color, check attribute to confirm color change
        iFramePage.selectAll();
        iFramePage.switchToMainArea();
        iFramePage.selectFormat().selectColor().selectRedColor();
        iFramePage.switchToEditArea();
        iFramePage.assertTextColor(expectedColour);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }
}


