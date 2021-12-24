import Driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {
   static WebDriver webDriver;




    @BeforeTest
    public static void startBrowser() {
        webDriver = DriverFactory.getDriver();
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
