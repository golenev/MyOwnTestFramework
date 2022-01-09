package helpers;
import configurations.DriverConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static driver.DriverFactory.getDriver;

public class CheckFileExist {
public static Logger logger = LogManager.getLogger();

    public static boolean isFileExist(String filePathString){
        logger.info("метод ждёт, пока файл не скачается");
        Path filePath = Paths.get(filePathString);
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), DriverConfiguration.getExplicitWaitToInt());
        webDriverWait.until(a -> filePath.toFile().exists());
        if (Files.exists(Paths.get(filePathString)) && !Files.isDirectory(Paths.get(filePathString))) {
            return true;
        } return false;
    }
}
