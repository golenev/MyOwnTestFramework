import driver.DriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import configurations.DriverConfiguration;

import static driver.DriverFactory.getDriver;


public class BaseTest {
   static WebDriver webDriver;
    public static Logger logger = LogManager.getLogger();

    @BeforeMethod
    /**
     * обоснование внутри исходного класса
     */
    public static void startBrowser() {
        webDriver = DriverFactory.getDriver(true);
    }

    @AfterClass
     public static void tearsFall() {
     getDriver().quit();
     }
  }
