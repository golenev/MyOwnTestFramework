package pages;

import elements.Button;
import elements.TextElements;
import org.openqa.selenium.By;
import static driver.DriverFactory.getDriver;
import java.util.HashMap;
import java.util.Map;

public class UsersFromTablePage extends AbstractPage {
    /**
     * ниже ключи для хэшмапы
     */
    public static String FIRST_CELL = "firstName";
    public static String SECOND_CELL = "lastName";
    public static String THIRD_CELL = "age";
    public static String FOURTH_CELL = "email";
    public static String FIFTH_CELL = "salary";
    public static String SIXTH_CELL = "department";
    public final String DELETE_USER_BUTTON = "deleteLastUserButton";
    public final String FOURTH_LINE = "forthLine";


    /**
     * ниже я использовал локаторы с индексами, чтобы получать из
     * ячеек таблицы значения, которых _там_ещё_нет_, а также проверять
     * очистку ячеек после удаления из них данных, а локаторы с текстом могут меняться,
     * если добавляем ещё одного пользователя, а эти локаторы можно переиспользовать
     */
    private final TextElements firstCellText = new TextElements(By.xpath("(//div[@role='gridcell'])[22]"), "первая ячейка в таблице");
    private final TextElements secondCellText = new TextElements(By.xpath("(//div[@role='gridcell'])[23]"), "вторая ячейка в таблице");
    private final TextElements thirdCellText = new TextElements(By.xpath("(//div[@role='gridcell'])[24]"), "третья ячейка в таблице");
    private final TextElements fourthCellText = new TextElements(By.xpath("(//div[@role='gridcell'])[25]"), "четвёртая ячейка в таблице");
    private final TextElements fifthCellText = new TextElements(By.xpath("(//div[@role='gridcell'])[26]"), "пятая ячейка в таблице");
    private final TextElements sixthCellText = new TextElements(By.xpath("(//div[@role='gridcell'])[27]"), "шестая ячейка в таблице");
    private final Button deleteLastUserButton = new Button(By.xpath("//span[@id='delete-record-4']"), "кнопка Удалить последнего пользователя");
    private final TextElements forthLine = new TextElements(By.xpath("(//div[@role='rowgroup'])[4]"), "Последняя строка со всеми ячейками в таблице");

    public UsersFromTablePage() {
        super(By.xpath("//div[@id='registration-form-modal']"), "форма регистрации пользователя");

    }
    public String getFirstCellText (){
        return firstCellText.getText();
    }
    public String getSecondCellText (){
        return secondCellText.getText();
    }
    public String getThirdCellText (){
        return thirdCellText.getText();
    }
    public String getFourthCellText (){
        return fourthCellText.getText();
    }
    public String getFifthCellText (){
        return fifthCellText.getText();
    }
    public String getSixthCellText (){
        return sixthCellText.getText();
    }

    public Map<String, String> getActualAttributes(){
        Map<String, String> attributes = new HashMap<>();
        attributes.put(FIRST_CELL, getFirstCellText());
        attributes.put(SECOND_CELL, getSecondCellText());
        attributes.put(THIRD_CELL, getThirdCellText());
        attributes.put(FOURTH_CELL, getFourthCellText());
        attributes.put(FIFTH_CELL, getFifthCellText());
        attributes.put(SIXTH_CELL, getSixthCellText());
        return attributes;
    }

    public void deleteUserButtonClick(){
        deleteLastUserButton.click();
    }
    public String fourthLineGetText(){
        return forthLine.getText();
    }
    public Map<String, String>  getExpectedAttributes() {
        Map<String, String> expectedAttributes = new HashMap<>();
        expectedAttributes.put(UsersFromTablePage.FIRST_CELL, "Jon");
        expectedAttributes.put(UsersFromTablePage.SECOND_CELL, "Snow");
        expectedAttributes.put(UsersFromTablePage.THIRD_CELL, "30");
        expectedAttributes.put(UsersFromTablePage.FOURTH_CELL, "knownothing@gmail.com");
        expectedAttributes.put(UsersFromTablePage.FIFTH_CELL, "3000");
        expectedAttributes.put(UsersFromTablePage.SIXTH_CELL, "alpha");
        return expectedAttributes;
    }
    public Map<String, String> packAttributes(Object firstName, Object lastName, Object email, Object age, Object salary, Object department){
        Map<String, String> data = new HashMap<>();
        data.put(TablesPage.INPUT_FIRST_NAME, (String) firstName);
        data.put(TablesPage.INPUT_LAST_NAME, (String) lastName);
        data.put(TablesPage.INPUT_EMAIL, (String) email);
        data.put(TablesPage.INPUT_AGE, (String) age);
        data.put(TablesPage.INPUT_SALARY, (String) salary);
        data.put(TablesPage.INPUT_DEPARTMENT, (String) department);
        return data;
    }

}
