package pages;

import driver.DriverFactory;
import elements.AbstractElement;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import java.util.Map;
import static driver.DriverFactory.getDriver;

public class MainPage extends AbstractForm {

    private final String ALERT_FRAME_WIN_BUTTON = "alertFrameWinButton";
    private final String ELEMENTS_BUTTON = "elementsButton";
    private final String BROWSER_WINDOWS_BUTTON = "browserWindowsButton";
    private final String JOIN_NOW_BUTTON = "joinNowButton";

    public MainPage(){
        super();
        getDriver().get(DriverFactory.getUrl());
        Button alertFrameWinButton = new Button(By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']"));
        Button elementsButton = new Button(By.xpath("//h5[normalize-space()='Elements']"));
        Button browserWindowsButton = new Button(By.xpath("//span[normalize-space()='Browser Windows']"));
        Button joinNowButton = new Button(By.xpath("//img[@alt='Selenium Online Training']"));
        Map <String, AbstractElement> locators = new HashMap<>();
        locators.put(ALERT_FRAME_WIN_BUTTON, alertFrameWinButton);
        locators.put(ELEMENTS_BUTTON, elementsButton);
        locators.put(BROWSER_WINDOWS_BUTTON, browserWindowsButton);
        locators.put(JOIN_NOW_BUTTON, joinNowButton);
        this.locators = locators;
    }

    public void alertFrameWinButtonOpen(){
        locators.get(ALERT_FRAME_WIN_BUTTON).click();
    }
    public void elementsButtonClick(){
        locators.get(ELEMENTS_BUTTON).click();
    }
    public void browserWindowsButtonClick(){
        locators.get(BROWSER_WINDOWS_BUTTON).click();
    }
    public boolean isJoinNowButtonPresence (){
        return locators.get(JOIN_NOW_BUTTON).isPresence();
    }

}
