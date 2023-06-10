package tests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest extends BaseTestClass {

    WebDriver driver;

    @BeforeMethod
    public void setUpTest(){
        driver = setUpDriver();
    }

    @Test
    public void TC04(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement element1 = $("#column-a");
        SelenideElement element2 = $("#column-b");
        // drag and drop element in order to switch positions and check positions again
        $("#column-a").dragAndDropTo("#column-b");
        $(element1).shouldHave(text("B"));
        $(element2).shouldHave(text("A"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(){
        quitDriver(driver);
    }

}
