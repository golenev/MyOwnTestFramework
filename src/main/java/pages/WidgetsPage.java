package pages;

import configurations.DriverConfiguration;
import elements.Button;
import elements.TextElements;
import helpers.GeneratorRandomNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static driver.DriverFactory.getDriver;

public class WidgetsPage extends AbstractPage {
    private final Button widgetsButton = new Button(By.xpath("//h5[normalize-space()='Widgets']"), "кнопка Виджеты");
    private final Button progressBar = new Button(By.xpath("//div[@role='progressbar']"), "Прогресс бар");
    private final Button sliderButton = new Button(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"), "Слайдер");
    private final Button sliderPointer = new Button(By.xpath("//input[@type='range']"), "Указатель слайдера");
    private final Button progressBarButton = new Button(By.xpath("//span[normalize-space()='Progress Bar']"), "Прогресс бар");
    private final Button startProgressButton = new Button(By.xpath("//button[@id='startStopButton']"), "кнопка Старт Прогресс бар");
    private final Button resetButton = new Button(By.xpath("//button[@id='resetButton']"), "кнопка Reset");
    private final TextElements valueOFSlider = new TextElements(By.xpath("//input[@id='sliderValue']"), "Установленное значение локатора");
    //стринги для JS, локаторы не принимает , а сами скрипты записывать в элементы сказали, что неправильно, поэтому храним тут
    private final String SCROLLBAR_ITEM = "div[class='element-list collapse show'] li[id='item-4'] span[class='text']";
    private final String valueOfProgressBar = "//div[@role='progressbar']";
    private final String pointToScroll = ".main-header";

    public WidgetsPage() {
        super(By.xpath("//div[@class='main-header']"), "SliderPage");
    }

    public void widgetsButtonClick()  {
        widgetsButton.click();

    }
    public void sliderButtonClick(){
        getDriver().navigate().refresh();
        sliderButton.click();
    }

    public void sliderPointerMover(){
        Actions actions = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath("//input[@type='range']"));
        actions.dragAndDropBy(element,
                GeneratorRandomNumber.getRandomNumberUsingInts(
                        Integer.parseInt(DriverConfiguration.getSliderXCoordinateValueMin()),
                Integer.parseInt(DriverConfiguration.getSliderXCoordinateValueMax())),
                Integer.parseInt(DriverConfiguration.getSliderYCoordinateFinal())).release().build().perform();

    }
    public void progressBarButtonClick(){
        scrollTo(SCROLLBAR_ITEM);
        progressBarButton.click();
    }

    public void clickWithWaitProgressButton()  {
        scrollTo(pointToScroll);
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(),DriverConfiguration.getExplicitWaitToInt(),
                DriverConfiguration.getCheckFrequencyTimeToInt());
        startProgressButton.click();
        webDriverWait.until(ExpectedConditions.attributeToBe(By.xpath(valueOfProgressBar), "aria-valuenow", "34" ));
        startProgressButton.click();
    }

    public String checkValueOfSlider (){
      return valueOFSlider.getAttrValue();
    }

    public String checkSliderItSelf (){
        return sliderPointer.getAttrValue();
    }

    public String checkValueOfProgBar(){
        return progressBar.getAttrAriaValue();
    }




}
