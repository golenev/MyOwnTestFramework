package elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static driver.DriverFactory.getDriver;

public abstract class AbstractElement {
    public static Logger logger = LogManager.getLogger();
    private final By by;



    public AbstractElement(By by) {
        this.by = by;
    }

    public void click() {
        getDriver().findElement(by).click();
       logger.debug("метод click нажимает на кнопку");

    }

    public boolean isPresence(){
        logger.info("проверяет, отображается ли элемент");
        return getDriver().findElement(getBy()).isDisplayed();


    }

    public String getText(){
        logger.info("получает текст из текстового элемента");
        return getDriver().findElement(getBy()).getText();

    }
    public void setText(String value){
        logger.info("передаёт текстовое значение в элемент");
        getDriver().findElement(getBy()).sendKeys(value);

    }
    protected By getBy(){
        return by;
    }

}
