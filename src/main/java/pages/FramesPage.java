package pages;

import elements.TextElements;
import helpers.SwitchBetweenFrames;
import org.openqa.selenium.By;
import static driver.DriverFactory.getDriver;

public class FramesPage extends AbstractPage {
   private final TextElements bigSampleText = new TextElements(By.id("sampleHeading"), "sampleHeading");
   private final TextElements littleSampleText = new TextElements(By.id("framesWrapper"), "framesWrapper");


    public FramesPage() {
        super(By.xpath("//div[@class='main-header']"), "Страница с Фреймами");
    }

    public String getBigSampleText(){
        SwitchBetweenFrames.switchToSecondFrame();

         return bigSampleText.getText();
    }

    public String getLittleSampleText(){
        SwitchBetweenFrames.switchToRootFrame();
        return littleSampleText.getText();
    }
}
