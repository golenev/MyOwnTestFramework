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

public abstract class AbstractPage {

    protected WebDriver webDriver;// = DriverFactory.getBrowser();
    protected Map<String, AbstractElement> locators;

    protected AbstractPage(WebDriver webDriver){
        this.locators = null;
        this.webDriver = webDriver;
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
