
import Driver.DriverFactory;
import configurations.DriverConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

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
    public void firstCase() throws InterruptedException {
      //  webDriver.get("https://demoqa.com/");



        MainPage mainPage = new MainPage(webDriver);
        mainPage.alertFrameWinButtonOpen();




       // DriverFactory.getBrowser().get("https://yandex.ru/");
    }

}
