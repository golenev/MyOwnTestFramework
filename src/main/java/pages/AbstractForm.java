package pages;

import elements.AbstractElement;
import elements.Button;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static driver.DriverFactory.getDriver;

import java.util.Map;
import java.util.Set;

public abstract class AbstractForm {
    public static Logger logger = LogManager.getLogger();
    protected Map<String, AbstractElement> locators;

    protected AbstractForm(){
        this.locators = null;

    }
    public String clickAndClosePrevious(Button button) throws InterruptedException {
        return getWindowByClickedLink(button, true, true, false);
    }

    public String clickSwitchAndCloseAll (Button button) throws InterruptedException {
        return getWindowByClickedLink(button, true, false, true);
    }

    public String clickAndCloseAll (Button button) throws InterruptedException {
        logger.info("открывает новое окно и закрывает его");
        return getWindowByClickedLink(button, false, false, true);
    }

    public String getWindowByClickedLink (Button button) throws InterruptedException {
        return getWindowByClickedLink(button,false, false, false);
    }

    public String getWindowByClickedLink(Button button, boolean switchToTarget, boolean closePrevious, boolean closeAll) throws InterruptedException {
        String currentWindow = getDriver().getWindowHandle();
        button.click();
        String targetWindow = getDriver().getWindowHandle();
        if (closeAll) {
            Set<String> windows = getDriver().getWindowHandles();
            if (switchToTarget){
                currentWindow = targetWindow;

            }
            for (String window : windows) {
                if (window.equals(currentWindow)) continue;
                getDriver().switchTo().window(window).close();
            }
            getDriver().switchTo().window(currentWindow);
            return currentWindow;
        }
        if (closePrevious) {
            getDriver().switchTo().window(currentWindow).close();
            getDriver().switchTo().window(targetWindow);
            return targetWindow;
        }
        if (switchToTarget && !currentWindow.equals(targetWindow)) {
            getDriver().switchTo().window(targetWindow);
            return targetWindow;
        }
        return currentWindow;

    }

    public AbstractElement getLocator(String name) {
        return locators.get(name);
    }

    public boolean clickWithAlert(Button button, int timeOut, String text){
      // logger.info("закрывает аллерт с ожиданием");
        try {
            button.click();
            Alert alert = (new WebDriverWait(getDriver(), timeOut)).until(ExpectedConditions.alertIsPresent());
            if (text != null) {
                alert.sendKeys(text);
            }
            alert.accept();
            return true;
        }
        catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public boolean clickWithAlert(Button button, int timeOut) {
        logger.info("закрывает аллерт с ожиданием");
       return clickWithAlert(button, timeOut, null);
    }



}
