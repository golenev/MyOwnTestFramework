package pages;

import driver.DriverFactory;
import elements.AbstractElement;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import java.util.Map;
import static driver.DriverFactory.getDriver;

public class MainPage extends AbstractPage {
    WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 3000);

    private final String ALERT_FRAME_WIN_BUTTON = "alertFrameWinButton";
    private final String ELEMENTS_BUTTON = "elementsButton";
    private final String BROWSER_WINDOWS_BUTTON = "browserWindowsButton";

    public MainPage(){
        super();
        getDriver().get(DriverFactory.getUrl());
        Button alertFrameWinButton = new Button(By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']"));
        Button elementsButton = new Button(By.xpath("//h5[normalize-space()='Elements']"));
        Button browserWindowsButton = new Button(By.xpath("//span[normalize-space()='Browser Windows']"));
        Map <String, AbstractElement> locators = new HashMap<>();
        locators.put(ALERT_FRAME_WIN_BUTTON, alertFrameWinButton);
        locators.put(ELEMENTS_BUTTON, elementsButton);
        locators.put(BROWSER_WINDOWS_BUTTON, browserWindowsButton);
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

}
