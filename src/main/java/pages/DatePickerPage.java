package pages;

import elements.Button;
import elements.TextElements;
import org.openqa.selenium.By;
import static driver.DriverFactory.getDriver;

public class DatePickerPage extends AbstractPage {
    private final Button datePickerButton = new Button(By.xpath("//span[normalize-space()='Date Picker']"), "ДатаПикер");
    private final TextElements dateAndTime = new TextElements(By.xpath("//input[@id='dateAndTimePickerInput']"), "Дата и время");
    private final TextElements dateInput = new TextElements(By.xpath("//input[@id='datePickerMonthYearInput']"), "Ввод даты");
    private final Button monthSelect = new Button(By.xpath("//select[@class='react-datepicker__month-select']"), "Выбор месяца");
    private final Button selectYear = new Button(By.cssSelector(".react-datepicker__year-select"), "Выбор года");
    private final Button februaryButton = new Button(By.xpath("//select[@class='react-datepicker__month-select']//option[@value='1']"), "Февраль");
    private final Button year2024 = new Button(By.xpath("//select[@class='react-datepicker__year-select']//option[@value='2024']"), "2024");
    private final Button february29 = new Button(By.xpath("//div[@aria-label='Choose Thursday, February 29th, 2024']"), "29 февраля");

    public DatePickerPage() {
        super(By.xpath("//div[@class='main-header']"), "DatePicker");

    }
    public void datePickerButtonClick(){
        datePickerButton.click();
    }

    public String getDateAndTimeAsAttr (){
        return dateAndTime.getAttrValue();
    }

    public String getDateInputAsAttr (){
        return dateInput.getAttrValue();
    }

    public void dateInputClick(){
        dateInput.click();
    }

    public void select2024Year () {
        selectYear.click();
        year2024.click();
    }

    public void monthSelectClick (){
        monthSelect.click();
        februaryButton.click();
        monthSelect.click();
    }
    public void choose29OfFebr (){
        february29.click();
    }

    public String getDateAsAttributeFromDatePickerPage(){
        return dateInput.getAttrValue();
    }

}
