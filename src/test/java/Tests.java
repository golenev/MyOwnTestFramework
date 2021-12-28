import driver.DriverFactory;
import configurations.DriverConfiguration;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import pages.*;
import java.util.HashMap;
import java.util.Map;
import static driver.DriverFactory.getDriver;

public class Tests extends BaseTest {

    @Test
    public void firstCase() {
        MainPage mainPage = new MainPage();
        mainPage.alertFrameWinButtonOpen();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.alertButtonClick();
        Assert.assertTrue(alertsFrameWindowsPage.alertButtonFirstClick());
        Assert.assertTrue(alertsFrameWindowsPage.alertButtonWithTimerClick());
        Assert.assertTrue(alertsFrameWindowsPage.alertConfirmButtonClick());
        Assert.assertTrue(alertsFrameWindowsPage.alertPromtButtonClick());
        BASIC_LOGGER.debug("проверка логгера на первом тест-кейсе");
    }

    @Test
    public void secondCase() {
        //работа с фреймами и семплами
        MainPage mainPage = new MainPage();
//проверка открытия главной страницы
        Assert.assertTrue(mainPage.isJoinNowButtonPresence());
        mainPage.alertFrameWinButtonOpen();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.nestedFramesButtonClick();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
//проверка надписей "Parent frame" и "Child Iframe"
        Assert.assertEquals(nestedFramesPage.getChildFrameText(), "Child Iframe", "ошибка, несоответствие");
        Assert.assertEquals(nestedFramesPage.getParentFrameText(), "Parent frame", "ошибка, несоответствие");
//без этого кнопка ниже не кликается,ожидания не помогают
        getDriver().navigate().refresh();
        nestedFramesPage.framesButtonClick();
        FramesPage framesPage = new FramesPage();
//проверка "This is a sample page"
        Assert.assertEquals(framesPage.getBigSampleText(), "This is a sample page", "несоответствие1");
        Assert.assertEquals(framesPage.getLittleSampleText(), "This is a sample page", "несоответствие2");
        BASIC_LOGGER.debug("проверка логгера на втором кейсе");

    }
    @DataProvider (name = "regForm")
    public Object [][] providerRegData(){
        return new Object[][] {
                {"Jon" , "Snow", "knownothing@gmail.com", "30", "3000", "alpha"},
        };
    }
    @Test (dataProvider = "regForm")
    public void thirdCase(Object firstName, Object lastName, Object email, Object age, Object salary, Object department) {
        MainPage mainPage = new MainPage();
        TablesPage tablesPage = new TablesPage();
        mainPage.elementsButtonClick();
//переходим на страницу WebTables
        tablesPage.webTablesClick();
        UsersFromTablePage usersFromTablePage = new UsersFromTablePage();
        Map<String, String> data = usersFromTablePage.packAttributes(firstName, lastName, email,age, salary, department);
//это данные для дата провайдера, они в другой класс не переносятся
       //заполняем таблицу данными из мапы выше
        tablesPage.fillingTheTable(data);
//добавление в мапу ожидаемых значений ячеек четвёртой строки
        usersFromTablePage.getExpectedAttributes();
        Map<String, String> actualAttributes = usersFromTablePage.getActualAttributes();
//проверка двух карт после добавления пользователя
        Assert.assertEquals(usersFromTablePage.getExpectedAttributes(), actualAttributes);
//удаляем созданного пользователя
        usersFromTablePage.deleteUserButtonClick();
//проверяем, что на месте только что удалённой строки с данными нет этих данных
        Assert.assertNotEquals(usersFromTablePage.fourthLineGetText(),"Jon\tSnow\tknownothing@gmail.com\t30\t3000\talpha");
        BASIC_LOGGER.debug("проверка логгера на третьем тест-кейсе");
            }

    @Test
    public void fourthCase() throws InterruptedException {
        MainPage mainPage = new MainPage();
//проверка открытия главной страницы
        Assert.assertTrue(mainPage.isJoinNowButtonPresence());
        mainPage.alertFrameWinButtonOpen();
        mainPage.browserWindowsButtonClick();
        BrowserWindowPage browserWindowPage = new BrowserWindowPage(webDriver);
 //проверка Открыта страница с формой Browser Windows
        Assert.assertEquals(browserWindowPage.mainHeaderText(), "Browser Windows", "ошибка, несоответствие");
//Кликнуть на кнопку New Tab и сразу закрыть. Метод возвращает уникальное строковое значение страницы, поэтому его тип String
        Assert.assertEquals(browserWindowPage.newTabButtonClick(), getDriver().getWindowHandle(), "ошибка");
        browserWindowPage.elementButtonClick();
//Открыта страница с формой Browser Windows
        browserWindowPage.linksButtonClick();
//открываем новую вкладку и возвращаемся на первую, не закрывая вторую. Проверяем, что открыта первая вкладка по её String дескриптору
        Assert.assertEquals(browserWindowPage.simpleLinkButtonClick(), getDriver().getWindowHandle(), "ошибка, не та страница");
        BASIC_LOGGER.debug("проверка логгера на четвёртом тест-кейсе");
    }

}
