package pages;

import Driver.DriverFactory;
import elements.AbstractElement;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class MainPage extends AbstractPage {
    private final String ALERT_FRAME_WIN_BUTTON = "alertFrameWinButton";

    public MainPage(WebDriver webDriver){
        super(webDriver);
        webDriver.get(DriverFactory.getUrl());
        Button alertFrameWinButton = new Button(webDriver, By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']"));
        Map <String, AbstractElement> locators = new HashMap<>();
        locators.put(ALERT_FRAME_WIN_BUTTON, alertFrameWinButton);
        this.locators = locators;
    }



    public void alertFrameWinButtonOpen(){
        locators.get(ALERT_FRAME_WIN_BUTTON).click();
    }


}
