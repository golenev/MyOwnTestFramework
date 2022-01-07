package pages;


import elements.Button;
import org.openqa.selenium.By;
import static driver.DriverFactory.getDriver;
import static configurations.DriverConfiguration.getMainPageURL;

public class MainPage extends AbstractPage {

    private final Button alertFrameWinButton = new Button(By.xpath("//h5[normalize-space()='Alerts, Frame & Windows']"), "Alerts, Frame & Windows");
    private final Button elementsButton = new Button(By.xpath("//h5[normalize-space()='Elements']"), "Элементы");
    private final Button browserWindowsButton = new Button(By.xpath("//span[normalize-space()='Browser Windows']"), "Browser Windows");
    private final Button joinNowButton = new Button(By.xpath("//img[@alt='Selenium Online Training']"), "Selenium Online Training");

    public MainPage(){
        super(By.xpath("//img[@alt='Selenium Online Training']"),"Реклама тренинг центра Селениум");
        String URL = getMainPageURL();
        getDriver().get(URL);
            }

    public void alertFrameWinButtonOpen() {
        alertFrameWinButton.click();
            }

    public void elementsButtonClick(){
        elementsButton.click();
    }
    public void browserWindowsButtonClick(){
        browserWindowsButton.click();
    }
    public boolean isJoinNowButtonPresence (){
        return joinNowButton.isPresence();
    }
}
