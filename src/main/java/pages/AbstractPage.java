package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import static driver.DriverFactory.getDriver;

public abstract class AbstractPage {
    public static Logger logger = LogManager.getLogger();
    private final String name;
    private final By uniqueLocator;

    protected AbstractPage(By uniqueLocator, String name) {
        logger.info("Переход на страницу " + name);
        this.name = name;
        this.uniqueLocator = uniqueLocator;
    }
    public void scrollTo(String locator) {
        logger.info("автоматический скролл до элемента ");
        ((JavascriptExecutor) getDriver()).executeScript("document.querySelector(\"" + locator + "\").scrollIntoView();");
    }
    public boolean isPageOpen() {
        logger.info("проверка наличия уникального элемента на данной странице");
        return getDriver().findElement(uniqueLocator).isDisplayed();
    }
}
