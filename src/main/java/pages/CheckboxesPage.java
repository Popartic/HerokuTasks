package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import testingData.StandardData;
import testingData.TimeDelay;


public class CheckboxesPage extends BasePageClass{
    private final String checkboxesUrl = StandardData.CHECKBOXES_URL;
    private final By checkbox1Location = By.xpath("//form[@id='checkboxes']/input[1]");
    private final By checkbox2Location = By.xpath("//form[@id='checkboxes']/input[2]");

    public CheckboxesPage(WebDriver driver){super(driver);}

    public CheckboxesPage open(){
        openUrl(checkboxesUrl);
        return this;
    }
    public void checkingBox1Status() {
        WebElement element = waitForWebElementToBeVisible(checkbox1Location, TimeDelay.DELAY_3_SEC);
        String status = element.isSelected() ? "checked" : "unchecked";
        System.out.println("Checkbox 1 is " + status);
    }
    public void checkingBox2Status() {
        WebElement element = waitForWebElementToBeVisible(checkbox2Location, TimeDelay.DELAY_3_SEC);
        String status = element.isSelected() ? "checked" : "unchecked";
        System.out.println("Checkbox 2 is " + status);
    }
    public CheckboxesPage checkBox1(){
        click(checkbox1Location);
        return this;
    }
    public CheckboxesPage checkBox2(){
        click(checkbox2Location);
        return this;
    }
    public void assertCheckbox1Status(String expectedStatus) {
        WebElement element = waitForWebElementToBeVisible(checkbox1Location, TimeDelay.DELAY_3_SEC);
        String status = element.isSelected() ? "checked" : "unchecked";
        System.out.println("Checkbox 1 is " + status);
        Assert.assertEquals(status, expectedStatus);
    }
    public void assertCheckbox2Status(String expectedStatus) {
        WebElement element = waitForWebElementToBeVisible(checkbox2Location, TimeDelay.DELAY_3_SEC);
        String status = element.isSelected() ? "checked" : "unchecked";
        System.out.println("Checkbox 1 is " + status);
        Assert.assertEquals(status, expectedStatus);
    }


}
