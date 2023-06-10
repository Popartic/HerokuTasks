package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DownloadPage;
import testingData.StandardData;
import java.io.File;
import java.io.IOException;

public class DownloadTest extends BaseTestClass {

    WebDriver driver;
    String fileName;
    String downloadPath;

    @BeforeMethod
    public void setUpTest() {
        driver = setUpDriver();
        fileName = StandardData.DOWNLOAD_FILE_NAME;
    }

    @Test
    public void TC06() throws IOException {
        DownloadPage downloadPage = new DownloadPage(driver);

        downloadPage.open();
        downloadPage.downloadFile();
        downloadPage.checkFileDownloadStatus();
        downloadPage.printFileContent();
    }

    @AfterMethod
    public void tearDown() {
        downloadPath = System.getProperty("user.home")+ "/Downloads/";
        File file = new File(downloadPath + fileName);
        if (file.exists()) {
            file.delete();
            System.out.println("File is deleted successfully.");
        }else {
            System.out.println("File is not deleted successfully");
        }
        driver.quit();
    }
}

