package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import testingData.TimeDelay;

import java.time.Duration;

public class WebDriverUtils {

    private static WebDriver driver;

    public static WebDriver setUpWebDriver(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeDelay.DELAY_3_SEC));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeDelay.DELAY_5_SEC));
        driver.manage().window().maximize();
        return driver;
    }
    public static void driverExit(WebDriver driver) {driver.quit();}
}
