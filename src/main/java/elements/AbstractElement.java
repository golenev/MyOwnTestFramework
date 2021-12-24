package elements;

import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class AbstractElement {
    private final By by;
    protected WebDriver webDriver;


    public AbstractElement(WebDriver webDriver, By by) {
        this.by = by;
        this.webDriver = webDriver;
    }

    public void click() {
        webDriver.findElement(by).click();
    }

    protected By getBy(){
        return by;
    }


}
