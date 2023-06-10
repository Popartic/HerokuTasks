package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testingData.StandardData;

public class DragAndDropPage extends BasePageClass{
    private final String dragURL = StandardData.DRAG_URL;
    private final By objectALocator = By.xpath("//div[@id='column-a']");
    private final By objectBLocator = By.xpath("//div[@id='column-b']");

    public DragAndDropPage(WebDriver driver){super(driver);}

    public DragAndDropPage open(){
        openUrl(dragURL);
        return this;
    }
    public DragAndDropPage checkPosition(){
        checkElementsPosition(objectALocator,objectBLocator);
        return this;
    }
    public DragAndDropPage dragAndDrop(){
        dragAndDrop(objectALocator,objectBLocator);
        return this;
    }
    public DragAndDropPage dragAndDropByOffset(){
        dragAndDropByOffset(objectALocator);
        return this;
    }


}
