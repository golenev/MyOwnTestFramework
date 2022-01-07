package pages;

import configurations.DriverConfiguration;
import elements.Button;
import helpers.AlertOperations;
import helpers.ConstantTimeClass;
import helpers.GeneratorRandomWords;
import org.openqa.selenium.By;
import static driver.DriverFactory.getDriver;

public class AlertsFrameWindowsPage extends AbstractPage {

    private final Button alertButton = new Button(By.xpath("//span[normalize-space()='Alerts']"), "Вход на страницу алертов");
    private final Button alertButtonFirst = new Button(By.xpath("//button[@id='alertButton']"), "обычный алерт");
    private final Button alertButtonWithTimer = new Button(By.xpath("//button[@id='timerAlertButton']"), "Алерт с задержкой");
    private final Button alertConfirmButton = new Button(By.xpath("//button[@id='confirmButton']"), "Алерт с кнопкой Подтвердить");
    private final Button alertPromtButton = new Button(By.xpath("//button[@id='promtButton']"), "Алерт Промт");
    private final Button nestedFramesButton = new Button(By.xpath("//span[normalize-space()='Nested Frames']"), "Вложенные фреймы");

    public AlertsFrameWindowsPage() {
        super(By.xpath("//div[@class='main-header']"), "Страница с Алертами");

    }
    public void alertButtonClick(){
        alertButton.click();
    }
    public boolean alertButtonFirstClick(){
        Button button = (Button) alertButtonFirst;
        return AlertOperations.clickWithAlert(button, Integer.parseInt(DriverConfiguration.getExplicitWait()));

    }
    public boolean alertButtonWithTimerClick(){
        Button button = (Button) alertButtonWithTimer;
        return AlertOperations.clickWithAlert(button, Integer.parseInt(DriverConfiguration.getExplicitWait()));

    }
    public boolean alertConfirmButtonClick(){
        Button button = (Button) alertConfirmButton;
        return  AlertOperations.clickWithAlert(button, Integer.parseInt(DriverConfiguration.getExplicitWait()));
    }

    public boolean alertPromtButtonClick() {

        Button button = (Button) alertPromtButton;
        return AlertOperations.clickWithAlert(button, Integer.parseInt(DriverConfiguration.getExplicitWait()), GeneratorRandomWords.generateRandomWords());
    }
    public void nestedFramesButtonClick(){
        nestedFramesButton.click();
    }
}
