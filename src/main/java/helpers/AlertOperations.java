package helpers;

import elements.Button;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.DriverFactory.getDriver;

public class AlertOperations {
    public static Logger logger = LogManager.getLogger();

    /**
     * Универсальный метод закрывает alert с ожиданием
     *
     * @param button
     * @param timeOut
     * @param text
     * @return
     */
    public static boolean clickWithAlert(Button button, int timeOut, String text) {
        logger.info("закрывает аллерт с ожиданием");
        try {
            button.click();
            Alert alert = (new WebDriverWait(getDriver(), timeOut)).until(ExpectedConditions.alertIsPresent());
            if (text != null) {
                alert.sendKeys(text);
            }
            alert.accept();
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public static boolean clickWithAlert(Button button, int timeOut) {
        return clickWithAlert(button, timeOut, null);
    }
}
