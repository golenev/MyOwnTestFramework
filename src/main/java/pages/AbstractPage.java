package pages;

import Driver.DriverFactory;
import elements.AbstractElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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

}
