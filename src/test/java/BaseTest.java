import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
   static WebDriver webDriver;




    @BeforeTest
    public static void startBrowser() {
        webDriver = DriverFactory.getDriver(true);
    }

    /*@BeforeClass
    void setupBrowser() {

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        //webDriverWait = new WebDriverWait(webDriver, 10);
        //actions = new Actions(webDriver);
        //webDriver.get("chrome://settings/clearBrowserData"); //очищаем кэш
       //WebDriverManager.chromedriver().setup();

    }*/


    // @AfterAll
    // public static void tearsFall() {
    //    webDriver.close();
    //   }
}
