import driver.DriverFactory;
import configurations.DriverConfiguration;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import static driver.DriverFactory.getDriver;

public class Tests extends BaseTest {

    @Test
    public void checkConfig(){
        Assert.assertEquals("CHROME", DriverConfiguration.props.getProperty("BROWSER"));
        Assert.assertEquals("https://demoqa.com/", DriverConfiguration.props.getProperty("URL"));
        Assert.assertEquals("https://demoqa.com/", DriverFactory.getUrl());
        Assert.assertEquals("chrome", DriverFactory.getBrowserName());
        //Assert.assertTrue(DriverFactory.getDriver() instanceof WebDriver);
    }

    @Test
    public void firstCase() throws InterruptedException {
        //аллерты. всё работает
        MainPage mainPage = new MainPage();
        mainPage.alertFrameWinButtonOpen();
        Thread.sleep(1000);
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.alertButtonClick();
        Assert.assertTrue(alertsFrameWindowsPage.alertButtonFirstClick());
        Assert.assertTrue(alertsFrameWindowsPage.alertButtonWithTimerClick());
        Assert.assertTrue(alertsFrameWindowsPage.alertConfirmButtonClick());
        Assert.assertTrue(alertsFrameWindowsPage.alertPromtButtonClick());

    }

    @Test
    public void secondCase() {
        //работа с фреймами и семплами
        MainPage mainPage = new MainPage();
        mainPage.alertFrameWinButtonOpen();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.nestedFramesButtonClick();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        nestedFramesPage.getChildFrameText();
        nestedFramesPage.getParentFrameText();
        getDriver().navigate().refresh(); //без этого кнопка ниже не кликается,ожидания не помогают
        nestedFramesPage.framesButtonClick();
        FramesPage framesPage = new FramesPage();
        System.out.println(framesPage.getBigSampleText() + "чьл-то");
        System.out.println(framesPage.getLittleSampleText() + "чьл-то");
        Assert.assertEquals(framesPage.getBigSampleText(), "This is a sample page", "несоответствие");
        Assert.assertEquals(framesPage.getLittleSampleText(), "This is a sample page", "несоответствие");

    }
    @DataProvider (name = "regForm")
    public Object [][] providerRegData(){
        return new Object[][] {
                {"Jon" , "Snow", "knownothing@gmail.com", "30", "3000", "alpha"},
               // {"Buttercup" , "Cumbersnatch", "BudapestCandygram@mail.ru", "41", "2000", "beta"}
        };
    }


    @Test (dataProvider = "regForm")
    public void thirdCase(Object firstName, Object lastName, Object email, Object age, Object salary, Object department) throws InterruptedException {
        //заполнение таблицы
        MainPage mainPage = new MainPage();
        TablesPage tablesPage = new TablesPage();
        mainPage.elementsButtonClick();
        tablesPage.webTablesClick();
        Map<String, String> data = new HashMap<>();
        data.put(tablesPage.INPUT_FIRST_NAME, (String) firstName);
        data.put(tablesPage.INPUT_LAST_NAME, (String) lastName);
        data.put(tablesPage.INPUT_EMAIL, (String) email);
        data.put(tablesPage.INPUT_AGE, (String) age);
        data.put(tablesPage.INPUT_SALARY, (String) salary);
        data.put(tablesPage.INPUT_DEPARTMENT, (String) department);
        tablesPage.fillingTheTable(data);
        Map<String, String> expectedAttributes = new HashMap<>();
        expectedAttributes.put(UsersFromTablePage.FIRST_CELL, "Jon");
        expectedAttributes.put(UsersFromTablePage.SECOND_CELL, "Snow");
        expectedAttributes.put(UsersFromTablePage.THIRD_CELL, "knownothing@gmail.com");
        expectedAttributes.put(UsersFromTablePage.FOURTH_CELL, "30");
        expectedAttributes.put(UsersFromTablePage.FOURTH_CELL, "3000");
        expectedAttributes.put(UsersFromTablePage.FOURTH_CELL, "alpha");
        UsersFromTablePage usersFromTablePage = new UsersFromTablePage();
        Map<String, String> actualAttributes = usersFromTablePage.getAttributes();
//проверка двух карт после добалвения пользователя
// Assert.assertEquals(expectedAttributes, actualAttributes);
        usersFromTablePage.deleteUserButtonClick();
//проверяем, что на месте только что удалённой строки ничего нет
        Assert.assertNotEquals(usersFromTablePage.fourthLineGetText(),"Jon\tSnow\tknownothing@gmail.com\t30\t3000\talpha");

            }

    @Test
    public void fourthCase() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.alertFrameWinButtonOpen();
        mainPage.browserWindowsButtonClick();
        BrowserWindowPage browserWindowPage = new BrowserWindowPage(webDriver);
        browserWindowPage.newTabButtonClick();
        browserWindowPage.elementButtonClick();
        browserWindowPage.linksButtonClick();
        browserWindowPage.simpleLinkButtonClick();
    }

}
