package driver;

import configurations.DriverConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static configurations.DriverConfiguration.getMainPageURL;
import static configurations.DriverConfiguration.getBrowserName;


public class DriverFactory {

    private static String URL = getMainPageURL();
    private static String BROWSER = getBrowserName();
    private static WebDriver webDriver = null;
    //static Dimension dimension = new Dimension(1920, 1080);
    static Dimension dimension = new Dimension(DriverConfiguration.getDimensionXLineToInt(), DriverConfiguration.getDimensionYLineToInt());

    public static String getUrl(){
        return URL;
    }


    /**
     * Синглтон для всех страниц при использовании
     * вне режима тестирования. Драйвер создаётся единожды,
     * что ускоряет работу приложения, экономит вычислительные ресурсы
     * @return
     */
    public static WebDriver getDriver(){
        return getDriver(URL, false);
    }

    /**
     * При тестировании ноебходимо пересоздавать
     * драйвер до открытия каждой страницы. Флаг force принудительно пересоздаёт его
     * @param force
     * @return
     */
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
        webDriver.manage().window().setSize(dimension);
        return webDriver;
    }
}
