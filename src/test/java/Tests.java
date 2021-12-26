
import Driver.DriverFactory;
import configurations.DriverConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

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
    public void secondCase() throws InterruptedException {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.alertFrameWinButtonOpen();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage(webDriver);
        alertsFrameWindowsPage.nestedFramesButtonClick();
        NestedFramesPage nestedFramesPage = new NestedFramesPage(webDriver);
        nestedFramesPage.getChildFrameText();
        nestedFramesPage.getParentFrameText();
        Thread.sleep(2000);
        nestedFramesPage.framesButtonClick();

    }
    @Test
    public void thirdCase() throws InterruptedException {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.elementsButtonClick();
        TablesPage tablesPage = new TablesPage(webDriver);
        tablesPage.webTablesClick();
        tablesPage.addNewTablesClick();
        tablesPage.fillingTheTable();

    }

    @Test
    public void fourthCase() throws InterruptedException {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.alertFrameWinButtonOpen();
        mainPage.browserWindowsButtonClick();
        BrowserWindowPage browserWindowPage = new BrowserWindowPage(webDriver);
        browserWindowPage.newTabButtonClick();
        browserWindowPage.elementButtonClick();
        browserWindowPage.linksButtonClick();
        browserWindowPage.simpleLinkButtonClick();
    }



}
