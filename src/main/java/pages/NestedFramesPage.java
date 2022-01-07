package pages;

import elements.Button;
import elements.TextElements;
import org.openqa.selenium.By;
import static driver.DriverFactory.getDriver;

public class NestedFramesPage extends AbstractPage {

    private final TextElements childFrameText = new TextElements(By.tagName("p"), "фрейм наследник");
    private final TextElements parentFrameText = new TextElements(By.tagName("body"), "родительский фрейм");
    private final TextElements framesText1 = new TextElements(By.id("frame1Wrapper"), "фрейм обёртка");
    private final Button framesButton = new Button(By.xpath("//span[normalize-space()='Frames']"), "кнопка Frames");

    public NestedFramesPage() {
        super(By.xpath("//div[@class='main-header']"), "Страница NestedFrames");
    }

    public String getChildFrameText(){
       getDriver().switchTo().frame("frame1").switchTo().frame(0);
       return childFrameText.getText();
    }
    public String getParentFrameText(){
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(1);
        return parentFrameText.getText();
    }

    public void framesButtonClick() {
        framesText1.click();
    }

}
