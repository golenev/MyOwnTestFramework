import helpers.CheckFileExist;
import helpers.GeneratorActualDateAndTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import java.util.Map;
import static driver.DriverFactory.getDriver;

public class Tests extends BaseTest {

     @Test
     public void firstCase() {
         MainPage mainPage = new MainPage();
         mainPage.alertFrameWinButtonOpen();
         AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
         alertsFrameWindowsPage.alertButtonClick();
         Assert.assertTrue(alertsFrameWindowsPage.alertButtonFirstClick(), "ошибка, несоответствие");
         Assert.assertTrue(alertsFrameWindowsPage.alertButtonWithTimerClick(), "ошибка, несоответствие");
         Assert.assertTrue(alertsFrameWindowsPage.alertConfirmButtonClick(), "ошибка, несоответствие");
         Assert.assertTrue(alertsFrameWindowsPage.alertPromtButtonClick(), "ошибка, несоответствие");
         logger.info("окончание проверок первого тест кейса");
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
         logger.info("Второй тест кейс успешно завершён");

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
//заполняем таблицу данными из мапы выше
         tablesPage.fillingTheTable(data);
//добавление в мапу ожидаемых значений ячеек четвёртой строки
         usersFromTablePage.getExpectedAttributes();
         logger.info("добавление в мапу ожидаемых значений ячеек четвёртой строки");
         Map<String, String> actualAttributes = usersFromTablePage.getActualAttributes();
//проверка двух карт после добавления пользователя
         Assert.assertEquals(usersFromTablePage.getExpectedAttributes(), actualAttributes, "ошибка, несоответствие");
//удаляем созданного пользователя
         usersFromTablePage.deleteUserButtonClick();
//проверяем, что на месте только что удалённой строки с данными нет этих данных
         Assert.assertNotEquals(usersFromTablePage.fourthLineGetText(),"Jon\tSnow\tknownothing@gmail.com\t30\t3000\talpha");
         logger.info("Третий тест кейс выполнен успешно");
             }

     @Test
     public void fourthCase() {
         MainPage mainPage = new MainPage();
//проверка открытия главной страницы
         Assert.assertTrue(mainPage.isPageOpen(), "ошибка, нет такого элемента");
         mainPage.alertFrameWinButtonOpen();
         mainPage.browserWindowsButtonClick();
         BrowserWindowPage browserWindowPage = new BrowserWindowPage();
//проверка Открыта страница с формой Browser Windows
         Assert.assertEquals(browserWindowPage.mainHeaderText(), "Browser Windows", "ошибка, несоответствие");
//Кликнуть на кнопку New Tab и сразу закрыть. Метод возвращает уникальное строковое значение страницы, поэтому его тип String
         Assert.assertEquals(browserWindowPage.newTabButtonClick(), getDriver().getWindowHandle(), "ошибка");
         browserWindowPage.elementButtonClick();
//Открыта страница с формой Browser Windows
         browserWindowPage.linksButtonClick();
//открываем новую вкладку и возвращаемся на первую, не закрывая вторую. Проверяем, что открыта первая вкладка по её String дескриптору
         Assert.assertEquals(browserWindowPage.simpleLinkButtonClick(), getDriver().getWindowHandle(), "ошибка, не та страница");
         logger.info("Четвёртый тест кейс успешно выполнен");
     }
    @Test
    public void fifthCase() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "ошибка, нет такого элемента");
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.widgetsButtonClick();
        widgetsPage.sliderButtonClick();
        Assert.assertTrue(widgetsPage.isPageOpen(), "ошибка, нет такого элемента");
//выставляем рандомное значение слайдера
        widgetsPage.sliderPointerMover();
//Значение рядом со слайдером соответствует случайно сгенерированному
        Assert.assertEquals(widgetsPage.checkSliderItSelf(), widgetsPage.checkValueOfSlider(), "ошибка, результаты не совпадают");
//клик со скроллом
        widgetsPage.progressBarButtonClick();
//клик со скроллом
        widgetsPage.clickWithWaitProgressButton();
        Assert.assertEquals(widgetsPage.checkValueOfProgBar(), "34", "ошибка, не то значение");
        logger.info("Пятый тест-кейс завершён");
    }

    @Test
    public void sixthCase() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen());
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.widgetsButtonClick();
        DatePickerPage datePickerPage = new DatePickerPage();
        Assert.assertTrue(datePickerPage.isPageOpen(), "ошибка, нет такого элемента");
        datePickerPage.datePickerButtonClick();
        Assert.assertEquals(datePickerPage.getDateAndTimeAsAttr(), GeneratorActualDateAndTime.getTimeAndDate(), "ошибка, несоответствие");
        Assert.assertEquals(datePickerPage.getDateInputAsAttr(), GeneratorActualDateAndTime.getDate(), "ошибка, несоответствие");
        datePickerPage.dateInputClick();
        datePickerPage.select2024Year();
        datePickerPage.monthSelectClick();
        datePickerPage.choose29OfFebr();
        Assert.assertEquals(datePickerPage.getDateAsAttributeFromDatePickerPage(), "02/29/2024", "ошибка, несоответствие");
        logger.info("Шестой тест кейс завершён успешно");
    }

    @Test
    public void seventhCase() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "ошибка, нет такого элемента");
        mainPage.elementsButtonClick();
        UploadDownloadPage uploadDownloadPage = new UploadDownloadPage();
        uploadDownloadPage.uploadAndDownloadButtonClick();
        uploadDownloadPage.downloadFile();
        uploadDownloadPage.uploadFile();
        /**
         * Проверяем сразу два условия.
         * Если файл существует с таким именем в указанной директории,
         * значит ранее он же успешно туда скачался и соответственно существует
         */
        Assert.assertTrue(CheckFileExist.isFileExist("C://sampleFile.jpeg"), "ошибка, неверный путь или файла нет");
        logger.info("Седьмой тест кейс завершён успешно");
    }

}