package elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import static driver.DriverFactory.getDriver;

public class Button extends AbstractElement{
    public static Logger logger = LogManager.getLogger();
    public Button(By by, String uniqueName) {
        super(by, uniqueName);
    }
}

