package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static driver.DriverFactory.getDriver;
import org.testng.log4testng.Logger;

public abstract class AbstractElement {
    public static final Logger BASIC_LOGGER = Logger.getLogger(AbstractElement.class);
    private final By by;



    public AbstractElement(By by) {
        this.by = by;
    }

    public void click() {
        getDriver().findElement(by).click();
        BASIC_LOGGER.debug("метод click нажимает на кнопку");

    }

    public boolean isPresence(){
        return getDriver().findElement(getBy()).isDisplayed();
        BASIC_LOGGER.info("info");

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
