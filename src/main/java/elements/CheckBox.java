package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox extends AbstractElement{
    public CheckBox(WebDriver webDriver, By by) {
        super(webDriver, by);
    }
    public boolean isChecked(){
        return this.webDriver.findElement(getBy()).isSelected();
    }
}
