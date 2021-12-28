package elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static driver.DriverFactory.getDriver;

public class TextElements extends AbstractElement{
    public static Logger logger = LogManager.getLogger();

    public TextElements(By by) {
        super(by);
    }

    public String getText(){
        logger.info("метод получает текст");
        return getDriver().findElement(getBy()).getText();

    }
    public void setText(String value){
        logger.info("передаёт значение в поле");
        getDriver().findElement(getBy()).sendKeys(value);
    }

}
