package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testingData.StandardData;

import java.io.IOException;

public class DownloadPage extends BasePageClass {
    private final String downloadUrl = StandardData.DOWNLOAD_URL;
    private final By fileLocator = By.xpath("//*[contains(@href,'some-file')]");
    private final String fileName = StandardData.DOWNLOAD_FILE_NAME;

    public DownloadPage(WebDriver driver){super(driver);}

    public DownloadPage open(){
        openUrl(downloadUrl);
        return this;
    }
    public DownloadPage downloadFile(){
        click(fileLocator);
        return this;
    }

    public DownloadPage checkFileDownloadStatus() throws IOException {
        checkDownload();
        return this;
    }
    public DownloadPage printFileContent() throws IOException {
        printFile();
        return this;
    }
    public DownloadPage deleteFile(){
        deleteFileFromDownloadFolder(fileName);
        return this;
    }
}
