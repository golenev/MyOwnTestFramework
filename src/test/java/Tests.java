
import Driver.DriverFactory;
import configurations.DriverConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPage;
import pages.MainPage;
import pages.NestedFramesPage;

import java.util.concurrent.TimeUnit;

public class Tests extends BaseTest {

    @Test
    public void checkConfig(){
        Assert.assertEquals("CHROME", DriverConfiguration.props.getProperty("BROWSER"));
        Assert.assertEquals("https://demoqa.com/", DriverConfiguration.props.getProperty("URL"));
        Assert.assertEquals("https://demoqa.com/", DriverFactory.getUrl());
        Assert.assertEquals("chrome", DriverFactory.getBrowserName());
        //Assert.assertTrue(DriverFactory.getDriver() instanceof WebDriver);
    }

    @Test
    public void firstCase() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.alertFrameWinButtonOpen();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage(webDriver);
        alertsFrameWindowsPage.alertButtonClick();
        alertsFrameWindowsPage.alertButtonFirstClick();
        alertsFrameWindowsPage.alertButtonWithTimerClick();
        alertsFrameWindowsPage.alertConfirmButtonClick();
        alertsFrameWindowsPage.alertPromtButtonClick();
    }

    @Test
    public void secondCase(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.alertFrameWinButtonOpen();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage(webDriver);
        alertsFrameWindowsPage.nestedFramesButtonClick();
        NestedFramesPage nestedFramesPage = new NestedFramesPage(webDriver);
        nestedFramesPage.getChildFrameText();
        nestedFramesPage.getParentFrameText();



    }
}
