package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static driver.DriverFactory.getDriver;

public class TextElements extends AbstractElement{
    public TextElements(By by) {
        super(by);
    }
    public String getText(){
        return getDriver().findElement(getBy()).getText();
    }
    public void setText(String value){
        getDriver().findElement(getBy()).sendKeys(value);
    }

}
