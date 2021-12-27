package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static driver.DriverFactory.getDriver;

public abstract class AbstractElement {
    private final By by;

    public AbstractElement(By by) {
        this.by = by;
    }

    public void click() {
        getDriver().findElement(by).click();
    }

    public String getText(){
        return getDriver().findElement(getBy()).getText();
    }
    public void setText(String value){
        getDriver().findElement(getBy()).sendKeys(value);
    }
    protected By getBy(){
        return by;
    }

}
