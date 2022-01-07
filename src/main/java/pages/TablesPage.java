package pages;

import elements.Button;
import elements.TextElements;
import org.openqa.selenium.By;
import java.util.Map;
import static driver.DriverFactory.getDriver;

public class TablesPage extends AbstractPage {
    /**
     * ниже блок для заполнения хэшмапы с данными пользователя
     */
    public final String WEB_TABLES = "webTables";
    public final String ADD_NEW_TABLES = "addNewTables";
    public static final String INPUT_FIRST_NAME = "inputFirstName";
    public static final String INPUT_LAST_NAME = "inputLastName";
    public static final String INPUT_EMAIL = "inputEmailName";
    public static final String INPUT_AGE = "inputAge";
    public static final String INPUT_SALARY = "inputSalary";
    public static final String INPUT_DEPARTMENT = "inputDepartment";
    public final String SUBMIT_BUTTON = "submitButton";

    /**
     * а это локаторы
     */
    private final Button webTables = new Button(By.xpath("//span[normalize-space()='Web Tables']"), "кнопка WEbTables");
    private final Button addNewTables = new Button(By.xpath("//button[@id='addNewRecordButton']"), "кнопка addNewTables");
    private final TextElements inputFirstName = new TextElements(By.xpath("//input[@id='firstName']"), "Поле для ввода имени");
    private final TextElements inputLastName = new TextElements(By.xpath("//div[@id='lastName-wrapper']//input"), "Поле для ввода фамилии");
    private final TextElements inputEmail = new TextElements(By.xpath("//input[@id='userEmail']"), "поле для ввода email");
    private final TextElements inputAge = new TextElements(By.xpath("//input[@id='age']"), "поле для ввода возраста");
    private final  TextElements inputSalary = new TextElements(By.xpath("//input[@id='salary']"), "поле для ввода зарплаты");
    private final  TextElements inputDepartment = new TextElements(By.xpath("//input[@id='department']"), "поле для ввода зарплаты");
    private final  Button submitButton = new Button(By.xpath("//button[@id='submit']"), "кнопка Подтвердить");


    public TablesPage() {
        super(By.xpath("//div[@class='main-header']"), "Страница с WebTables");

    }
    public void webTablesClick(){
        webTables.click();
    }

    public void fillingTheTable (Map<String, String> data) {
        addNewTables.click();
        inputFirstName.setText(data.get(INPUT_FIRST_NAME));
        inputLastName.setText(data.get(INPUT_LAST_NAME));
        inputEmail.setText(data.get(INPUT_EMAIL));
        inputAge.setText(data.get(INPUT_AGE));
        inputSalary.setText(data.get(INPUT_SALARY));
        inputDepartment.setText(data.get(INPUT_DEPARTMENT));
        submitButton.click();
            }
   }
