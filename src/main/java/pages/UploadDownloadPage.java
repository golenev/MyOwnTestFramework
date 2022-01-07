package pages;

import elements.Button;
import elements.TextElements;
import org.openqa.selenium.By;
import static driver.DriverFactory.getDriver;


public class UploadDownloadPage extends AbstractPage {
    Button downloadButton = new Button(By.xpath("//a[@id='downloadButton']"), "Кнопка Скачать");
    Button uploadButton = new Button(By.xpath("//input[@id='uploadFile']"), "Кнопка Загрузить");
    Button uploadAndDownloadButton = new Button(By.xpath("//span[normalize-space()='Upload and Download']"), "Upload and Download");
    TextElements uploadedFilePath = new TextElements(By.cssSelector("#uploadedFilePath"), "отображаемый путь и имя загруженного файла");

    public UploadDownloadPage() {
        super(By.xpath("//div[@class='main-header']"),"Страница для работы с загрузкой файла");
    }

    public void uploadAndDownloadButtonClick() {
        uploadAndDownloadButton.click();
    }

    public void downloadFile() {
        downloadButton.click();
    }

    public void uploadFile() {
        uploadButton.setText("C:\\sampleFile.jpeg");
    }

}
