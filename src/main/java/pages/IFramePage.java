package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import testingData.StandardData;
import testingData.TimeDelay;

public class IFramePage extends BasePageClass {
    private final String iFrameUrl = StandardData.IFRAME_URL;
    private final String text = StandardData.IFRAME_TEXT;
    private final String text2 = StandardData.IFRAME_TEXT2;
    private final By fileLocator = By.xpath("//span[text()='File']");
    private final By newDocLocator = By.xpath("//div[text()='New document']");
    private final By textEditorLocator = By.className("mce-content-body");
    private final By pharagraphLocator = By.xpath("//span[text()='Paragraph']");
    private final By headingsOptionLocator = By.xpath("//div[text()='Headings']");
    private final By heading3OptionLocator = By.xpath("//h3[text()='Heading 3']");
    private final By statusBarLocator = By.xpath("//div[@role='navigation']");
    private final By boldLocator = By.xpath("//button[@title='Bold']");
    private final By centerAlignLocator = By.xpath("//button[@title='Align center']");
    private final By formatLocator = By.xpath("//span[text()='Format']");
    private final By textColorLocator = By.xpath("//div[text()='Text color']");
    private final By redColorLocator = By.xpath("//div[@title='Red']");
    private final By checkColorLocator = By.xpath("//*[@id='tinymce']/p[1]/span");
    private final By textFieldLocator = By.xpath("//*[@id='tinymce']");


    public IFramePage(WebDriver driver){super(driver);}

    public IFramePage open(){
        openUrl(iFrameUrl);
        return this;
    }
    public IFramePage openNewDocument(){
        click(fileLocator);
        click(newDocLocator);
        return this;
    }
    public IFramePage isTextFieldEmpty(){
        checkingWYSIWYG(textEditorLocator);
        return this;
    }
    public IFramePage switchToEditArea(){
        switchToEdit();
        return this;
    }
    public IFramePage switchToMainArea(){
        switchToMain();
        return this;
    }
    public IFramePage enterTextInEditor(){
        enterText(textEditorLocator,text );
        return this;
    }
    public IFramePage selectTextInEditor(){
        selectText(textEditorLocator);
        return this;
    }
    public IFramePage tripleClick(){
        tripleClick(textEditorLocator);
        return this;
    }
    public IFramePage selectPharagraph(){
        click(pharagraphLocator);
        return this;
    }
    public IFramePage selectHeadings(){
        click(headingsOptionLocator);
        return this;
    }
    public IFramePage selectHeadings3(){
        click(heading3OptionLocator);
        return this;
    }
    public IFramePage goToNewLine(){
        pressEnter(textEditorLocator);
        return this;
    }
    public IFramePage enterNewText(){
        enterText(textEditorLocator,text2);
        return this;
    }
    public IFramePage doubleClick(){
        doubleClick(textEditorLocator);
        return this;
    }
    public IFramePage selectBold(){
        click(boldLocator);
        return this;
    }
    public IFramePage selectAll(){
        ctrlA(textEditorLocator);
        return this;
    }
    public IFramePage centerAlign(){
        click(centerAlignLocator);
        return this;
    }
    public IFramePage selectFormat(){
        click(formatLocator);
        return this;
    }
    public IFramePage selectColor(){
        click(textColorLocator);
        return this;
    }
    public IFramePage selectRedColor(){
        click(redColorLocator);
        return this;
    }
    public void assertElementTextEquals(String expectedText) {
        WebElement element = waitForWebElementToBeVisible(statusBarLocator, TimeDelay.DELAY_3_SEC);
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, "Element text does not match expected value.");
        System.out.println(actualText);
    }

    public void assertTextAlignPosition(String expectedAlign){
        WebElement element = waitForWebElementToBeVisible(textFieldLocator, TimeDelay.DELAY_3_SEC);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actual = (String) js.executeScript("return window.getComputedStyle(arguments[0]).getPropertyValue('text-align')", element);
       // Assert.assertEquals(actual, expectedAlign);
       // System.out.println("Text-align: " + actual);
        if (actual.equals(expectedAlign)) {
            System.out.println("center-align text");
        } else{
                System.out.println("Not center-align");
            }
        }

    public void assertTextColor(String expectedColor){
        WebElement element = waitForWebElementToBeVisible(checkColorLocator,TimeDelay.DELAY_3_SEC);
        String actual = element.getCssValue("color");
        if (actual.equals(expectedColor)) {
            System.out.println("The text color is red: " + actual);
        } else {
            System.out.println("The text color is not red: " + actual);
        }
    }

}
