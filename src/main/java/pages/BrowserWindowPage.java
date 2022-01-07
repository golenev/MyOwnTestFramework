package pages;

import elements.Button;
import elements.TextElements;
import helpers.WindowOperations;
import org.openqa.selenium.By;

import static driver.DriverFactory.getDriver;

public class BrowserWindowPage extends AbstractPage {
    private final Button newTabButton = new Button(By.xpath("//button[@id='tabButton']"), "открытие нового окна");
    private final Button elementsButton = new Button(By.xpath("(//div[contains(@class,'header-wrapper')])[1]"), "Элементы"); //ничего приличнее не смог найти, либо надо создавать List
    private final Button linksButton = new Button(By.xpath("//span[normalize-space()='Links']"), "Links Button");
    private final Button simpleLink = new Button(By.xpath("//a[@id='simpleLink']"), "простая ссылка");
    private final TextElements browserWindowHeader = new TextElements(By.xpath("//div[@class='main-header']"), "Хэдер");

    public BrowserWindowPage() {
        super(By.xpath("//div[@class='main-header']"), "Страница для работы с вкладками");

    }
    public String newTabButtonClick ()  {
        Button button = (Button) newTabButton;
        return WindowOperations.clickAndCloseAll(button);
    }

      public void elementButtonClick(){
          elementsButton.click();
      }

      public void linksButtonClick()  {
          linksButton.click();
      }

      public String simpleLinkButtonClick()  {
      String window1 = getDriver().getWindowHandle();
      simpleLink.click();
      return getDriver().switchTo().window(window1).getWindowHandle();
      }

      public String mainHeaderText (){
        return browserWindowHeader.getText();
      }

}
