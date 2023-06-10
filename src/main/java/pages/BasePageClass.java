package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testingData.TimeDelay;

import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;

public abstract class BasePageClass {
    protected WebDriver driver;

    public BasePageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    protected void openUrl(String url) {
        driver.get(url);
    }

    protected WebElement waitForWebElementToBeVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected WebElement waitForWebElementToBeVisible(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected List<WebElement> waitForWebElementsToBeVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    protected void clickOnWebElement(WebElement element) {
        element.click();
    }

    protected void click(By locator) {
        WebElement element = waitForWebElementToBeVisible(locator, TimeDelay.DELAY_3_SEC);
        clickOnWebElement(element);
    }
    protected void typeTextToWebElement(WebElement element, String text) {
        waitForWebElementToBeVisible(element, TimeDelay.DELAY_3_SEC);
        element.sendKeys(text);
    }
    protected void clearTextFromWebElement(WebElement element) {
        waitForWebElementToBeVisible(element, TimeDelay.DELAY_3_SEC);
        element.clear();
    }
    protected void clearAndTypeTextToWebElement(WebElement element, String text) {
        clearTextFromWebElement(element);
        typeTextToWebElement(element, text);
    }
    protected String textFromWebElement(By locator) {
        WebElement element = waitForWebElementToBeVisible(locator, TimeDelay.DELAY_3_SEC);
        String text = element.getText();
        return text;
    }
    protected void dragAndDrop(By locator1, By locator2) {
        Actions actions = new Actions(driver);
        WebElement element = waitForWebElementToBeVisible(locator1, TimeDelay.DELAY_3_SEC);
        WebElement target = waitForWebElementToBeVisible(locator2, TimeDelay.DELAY_3_SEC);
        actions.dragAndDrop(element, target).build().perform();
    }
    protected void dragAndDropByOffset(By locator1){
        Actions actions = new Actions(driver);
        WebElement element = waitForWebElementToBeVisible(locator1, TimeDelay.DELAY_3_SEC);
        actions.dragAndDropBy(element,200,0).build().perform();
    }
    protected void checkElementsPosition(By locator1, By locator2) {
        WebElement element = waitForWebElementToBeVisible(locator1, TimeDelay.DELAY_3_SEC);
        WebElement target = waitForWebElementToBeVisible(locator2, TimeDelay.DELAY_3_SEC);
        int elementPosition = element.getLocation().getX();
        int targetPosition = target.getLocation().getX();
        if (elementPosition < targetPosition) {
            System.out.println(elementPosition);
            assertTrue(true);
        } else {
            System.out.println("");
            assertTrue(false);
        }
    }

    protected void elementsFromRow(By locator) {
        List<WebElement> cells = waitForWebElementsToBeVisible(locator, TimeDelay.DELAY_3_SEC);
        for (WebElement cell : cells) {
            System.out.println(cell.getText());
        }
    }
    protected void checkingWYSIWYG(By locator) {
        WebElement element = waitForWebElementToBeVisible(locator, TimeDelay.DELAY_3_SEC);
        String textField = element.getText();
        if (textField.isEmpty()) {
            System.out.println("Text field is empty");
        } else {
            System.out.println("Text field is not empty");
        }
    }
    protected void switchToEdit() {
        driver.switchTo().frame("mce_0_ifr");
    }

    protected void switchToMain() {
        driver.switchTo().parentFrame();
    }

    protected void enterText(By locator, String text) {
        WebElement element = waitForWebElementToBeVisible(locator, TimeDelay.DELAY_3_SEC);
        element.sendKeys(text);
    }
    protected void selectText(By locator) {
        WebElement element = waitForWebElementToBeVisible(locator, TimeDelay.DELAY_3_SEC);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).clickAndHold().moveByOffset(80, 0).release().perform();
    }

    protected void tripleClick(By locator) {
        WebElement element = waitForWebElementToBeVisible(locator, TimeDelay.DELAY_3_SEC);
        Actions actions = new Actions(driver);
        actions.click(element).doubleClick(element).perform();
    }
    protected void doubleClick(By locator) {
        WebElement element = waitForWebElementToBeVisible(locator, TimeDelay.DELAY_3_SEC);
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }
    protected void selectFromDropdown(By locator1, String text) {
        Select selectList = new Select(waitForWebElementToBeVisible(locator1, TimeDelay.DELAY_3_SEC));
        selectList.selectByVisibleText(text);
    }
    protected void pressEnter(By locator) {
        WebElement element = waitForWebElementToBeVisible(locator, TimeDelay.DELAY_3_SEC);
        element.sendKeys(Keys.ENTER);
    }
    protected void ctrlA(By locator) {
        WebElement element = waitForWebElementToBeVisible(locator, TimeDelay.DELAY_3_SEC);
        element.sendKeys(Keys.chord(Keys.CONTROL, "A"));
    }

    protected void hovering(By locator) {
        WebElement element = waitForWebElementToBeVisible(locator, TimeDelay.DELAY_3_SEC);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    protected void checkDownload() throws IOException{
        String downloadPath = System.getProperty("user.home") + "/Downloads/";
        File file = new File(downloadPath + "some-file.txt");
        if (file.exists()) {
            System.out.println("File is downloaded");
        } else {
            System.out.println("File is NOT downloaded");
        }
        assertTrue(file.exists());
    }
    protected void printFile() throws IOException {
        String downloadsFolderPath = System.getProperty("user.home") + "/Downloads/";
        File file = new File (downloadsFolderPath + "some-file.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
    }
    protected void deleteFileFromDownloadFolder(String fileName){
        String downloadPath = System.getProperty("user.home")+ "/Downloads/";
        File fileToDelete = new File(downloadPath + "some-file.txt");
        fileToDelete.delete();
        if (fileToDelete.exists()) {
            System.out.println("Failed to delete the file");
        } else {
            System.out.println("File deleted successfully");
        }
    }
    protected void scrollToElement(By locator){
        WebElement element = waitForWebElementToBeVisible(locator,TimeDelay.DELAY_5_SEC);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    protected void scrollTo() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    protected void openNewPage(By locator) {
        WebElement element = waitForWebElementToBeVisible(locator, TimeDelay.DELAY_3_SEC);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).perform();

        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        allWindowHandles.remove(currentWindowHandle);
        String newWindowHandle = allWindowHandles.iterator().next();
        driver.switchTo().window(newWindowHandle);
    }
    protected void listSize (By locator) {
        WebElement element = waitForWebElementToBeVisible(locator, TimeDelay.DELAY_3_SEC);
        List<WebElement> resultList = element.findElements(By.tagName("li"));
        int count = resultList.size();
        System.out.println("Total number of pages: " + count);
    }
}

