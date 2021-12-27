package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static driver.DriverFactory.getDriver;

public class Button extends AbstractElement{
    public Button(By by) {
        super(by);
    }
}
