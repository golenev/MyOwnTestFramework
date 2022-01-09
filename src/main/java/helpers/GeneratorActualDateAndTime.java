package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.*;
import java.time.format.DateTimeFormatter;
import static driver.DriverFactory.getDriver;

public class GeneratorActualDateAndTime {
    public static Logger logger = LogManager.getLogger();

    public static String getTimeAndDate() {
        logger.info("Метод получает дату и время по указанному паттерну");
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("MMMM d, yyyy h:mm a");
        LocalDateTime dt = LocalDateTime.now();
        String actualDate = dt.format(formatter);
         return actualDate;
    }

    public static String getDate() {
        logger.info("Метод получает только дату по указанному паттерну");
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("MM/dd/yyyy");
        LocalDateTime dt = LocalDateTime.now();
        String actualDate = dt.format(formatter);
        return actualDate;
    }

}
