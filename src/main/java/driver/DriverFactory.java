package driver;

import configurations.DriverConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DriverFactory {
    private static String URL = DriverConfiguration.props.getProperty("URL");
    private static String BROWSER = DriverConfiguration.props.getProperty("BROWSER");
    private static WebDriver webDriver = null;

    public static String getUrl(){
        return URL;
    }

    public static String getBrowserName(){
        return BROWSER.toLowerCase();
    }

    public static WebDriver getDriver(){
        return getDriver(URL, false);
    }

    public static WebDriver getDriver(boolean force){
        return getDriver(URL, force);
    }

    public static WebDriver getDriver(String browser, boolean force) {

        if(webDriver != null && !force) return webDriver;

        switch (getBrowserName()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            default:
                throw new NotFoundException("The input in config file is not matching our browser names");
        }
        webDriver.manage().window().maximize();
        return webDriver;
    }
}