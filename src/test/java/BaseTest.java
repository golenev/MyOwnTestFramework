import driver.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import configurations.DriverConfiguration;
import org.testng.log4testng.Logger;
import static driver.DriverFactory.getDriver;


public class BaseTest {
   static WebDriver webDriver;

    @BeforeTest
    public static void startBrowser() {
        webDriver = DriverFactory.getDriver(true);
    }
    protected static final org.testng.log4testng.Logger BASIC_LOGGER = Logger.getLogger(BaseTest.class);


     @AfterClass
      public static void tearsFall() {
        getDriver().quit();
       }
}
