package elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.DriverFactory.getDriver;

public abstract class AbstractElement {
    public static Logger logger = LogManager.getLogger();
    private final By by;
    private final String uniqueName ;
    private final boolean isExplicit;

    public String getUniqueName() {
        return uniqueName;
    }

    public AbstractElement(By by, String uniqueName) {

        this(by, uniqueName, false);
    }

    public AbstractElement(By by, String uniqueName, boolean isExplicit) {
        this.by = by;
        this.uniqueName = uniqueName;
        this.isExplicit = isExplicit;
    }
    public WebElement getElement(){
        return getDriver().findElement(by);
    }

    public void click() {
        logger.info("универсальный метод click нажимает на  " + uniqueName + " с ожиданием");
            WebDriverWait webDriverWait = new WebDriverWait(getDriver(), ConstantTimeClass.EXPLICIT_WAIT);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(this.by));
            getElement().click();

        }
        public String getText(){
        logger.info("получает текст из текстового элемента " + uniqueName);
        return getElement().getText();
    }
    public String getAttrValue(){
        logger.info("получает текст из аттрибута Value " + uniqueName);
        return getElement().getAttribute("value");
    }
    public String getAttrAriaValue(){
        logger.info("получает текст из аттрибута Value " + uniqueName);
        return getElement().getAttribute("aria-valuenow");
    }
    public void setText(String value){
        logger.info("передаёт текстовое значение в элемент " + uniqueName);
        getElement().sendKeys(value);
    }
    public void setKeys (Keys value){

        getElement().sendKeys();
    }
    protected By getBy(){
        return by;
    }
}
