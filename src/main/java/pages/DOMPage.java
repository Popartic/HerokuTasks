package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testingData.StandardData;

public class DOMPage extends BasePageClass{

    private final String domUrl = StandardData.DOM_URL;
    private final By rowSixLocator = By.xpath("//div/table/tbody/tr[6]");

    public DOMPage(WebDriver driver){super(driver);}

    public DOMPage open(){
        openUrl(domUrl);
        return this;
    }
    public DOMPage rowSIX(){
        elementsFromRow(rowSixLocator);
        return this;
    }
}
