package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextElement extends AbstractElement{
    public TextElement(WebDriver webDriver, By by) {
        super(webDriver, by);
    }
    public String getText(){
        return this.webDriver.findElement(getBy()).getText();
    }
}
