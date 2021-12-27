package pages;

import Driver.DriverFactory;
import elements.AbstractElement;
import elements.Button;
import helpers.GeneratorRandomWords;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.Set;

public abstract class AbstractPage {

    protected WebDriver webDriver;// = DriverFactory.getBrowser();
    protected Map<String, AbstractElement> locators;

    protected AbstractPage(WebDriver webDriver){
        this.locators = null;
        this.webDriver = webDriver;
    }
    public String clickAndClosePrevious(Button button) throws InterruptedException {
        return getWindowByClickedLink(button, true, true, false);
    }

    public String clickSwitchAndCloseAll (Button button) throws InterruptedException {
        return getWindowByClickedLink(button, true, false, true);
    }

    public String clickAndCloseAll (Button button) throws InterruptedException {
        return getWindowByClickedLink(button, false, false, true);
    }

    public String getWindowByClickedLink (Button button) throws InterruptedException {
        return getWindowByClickedLink(button,false, false, false);
    }

    public String getWindowByClickedLink(Button button, boolean switchToTarget, boolean closePrevious, boolean closeAll) throws InterruptedException {
        String currentWindow = webDriver.getWindowHandle();
        button.click();
        String targetWindow = webDriver.getWindowHandle();
        if (closeAll) {
            Set<String> windows = webDriver.getWindowHandles();
            if (switchToTarget){
                currentWindow = targetWindow;

            }
            for (String window : windows) {
                if (window.equals(currentWindow)) continue;
                webDriver.switchTo().window(window).close();
            }
            webDriver.switchTo().window(currentWindow);
            return currentWindow;
        }
        if (closePrevious) {
            webDriver.switchTo().window(currentWindow).close();
            webDriver.switchTo().window(targetWindow);
            return targetWindow;
        }
        if (switchToTarget && !currentWindow.equals(targetWindow)) {
            webDriver.switchTo().window(targetWindow);
            return targetWindow;
        }
        return currentWindow;

    }

    public AbstractElement getLocator(String name) {
        return locators.get(name);
    }

    public boolean clickWithAlert(Button button, int timeOut, String text){
        try {
            button.click();
            Alert alert = (new WebDriverWait(webDriver, timeOut)).until(ExpectedConditions.alertIsPresent());
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
       return clickWithAlert(button, timeOut, null);
    }



}
