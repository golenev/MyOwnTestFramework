package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextInput extends AbstractElement{
    public TextInput(WebDriver webDriver,By by) {
        super(webDriver, by);
    }
    public String getText(){
        return webDriver.findElement(getBy()).getText();
    }
    public void setText(String value){
        webDriver.findElement(getBy()).sendKeys(value);
    }

}
