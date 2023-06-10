package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testingData.StandardData;
import testingData.TimeDelay;

public class ScrollPage extends BasePageClass {
    private final String scrollUrl = StandardData.SCROLL_URL;
    private final By homeRealEstateLocator = By.xpath("//a[text()='Home Real Estate']");
    private final By clickMoreLocator = By.cssSelector("li:nth-of-type(39)  .btn.btn-default.btn-sm.expand-page-button.page-more.pull-right");
    private final By clickRealEstateToOpenNewPage = By.cssSelector(".page-image > a[title='Home Real Estate']");
    private final By realEstateLinkLocator = By.xpath("//a[text()='Real Estate']");
    private final By searchBarLocator = By.xpath("//input[@placeholder='Enter Keywords']");
    private final By dropdownLocator = By.cssSelector(".nav.nav-list.navbar-left.navbar-nav.sort-block.u-unstyled  a[role='button']");
    private final By newestOptionLocator = By.xpath("//a[@data-val='Newest']");
    private final By pageTabLocator = By.xpath("//a[@class='page-tab']");
    private final By titleFromFirstElementLocator  = By.xpath("/html//section[@id='main']/div[@class='template-row']/div[@class='content-column']/div[4]/div[@class='col-md-12']/div[@class='thumbnails-grid']/ul/li[1]");
    private final By titleFromLastElementLocator = By.xpath("/html//section[@id='main']/div[@class='template-row']/div[@class='content-column']/div[4]/div[@class='col-md-12']/div[@class='thumbnails-grid']/ul/li[last()]");
    private final By listOfPagesLocator = By.xpath("//*[@id='main']/div/div[2]/div[4]/div/div/ul");


    public ScrollPage(WebDriver driver){super(driver);}

    public ScrollPage open(){
        openUrl(scrollUrl);
        return this;
    }
    public ScrollPage scrollToHomeRealEstate(){
        scrollToElement(homeRealEstateLocator);
        return this;
    }
    public ScrollPage scrollToBottom(){
        scrollTo();
        return this;
    }
    public ScrollPage hoverHomeRealEstate(){
        hovering(homeRealEstateLocator);
        return this;
    }
    public ScrollPage clickMore(){
        click(clickMoreLocator);
        return this;
    }
    public ScrollPage clickToNewPage(){
        click(clickRealEstateToOpenNewPage);
        return this;
    }
    public ScrollPage clickRealEstate(){
        openNewPage(realEstateLinkLocator);
        return this;
    }
    public ScrollPage enterSearchText(String text){
        WebElement element = waitForWebElementToBeVisible(searchBarLocator, TimeDelay.DELAY_3_SEC);
        clearAndTypeTextToWebElement(element, text);
        return this;
    }
    public ScrollPage pressEnter(){
        pressEnter(searchBarLocator);
        return this;
    }
    public ScrollPage selectNewestOption(){
        selectFromDropdown(dropdownLocator,"Newest");
        return this;
    }
    public ScrollPage clickPageTab(){
        click(pageTabLocator);
        return this;
    }
    public ScrollPage hoverDropdown(){
        hovering(dropdownLocator);
        return this;
    }
    public ScrollPage selectNewest(){
        click(newestOptionLocator);
        return this;
    }
    public ScrollPage firstPageTitle(){
        System.out.println("The first page title is: " + textFromWebElement(titleFromFirstElementLocator));
        return this;
    }
    public ScrollPage lastPageTitle(){
        System.out.println("The last page title is: " + textFromWebElement(titleFromLastElementLocator));
        return this;
    }
    public ScrollPage countListSize(){
        listSize(listOfPagesLocator);
        return this;
    }

}
