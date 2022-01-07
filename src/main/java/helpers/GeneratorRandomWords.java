package helpers;

import configurations.DriverConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GeneratorRandomWords {
    public static Logger logger = LogManager.getLogger();
    private static final java.util.UUID UUID = null;

    public static String generateRandomWords() {
        logger.info("Метод генерирует случайный набор букв и цифр");
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.substring(0, Math.min(uuid.length(), Integer.parseInt(DriverConfiguration.getMaxValueRandomNumbers())));
        System.err.println(uuid);
        return uuid;
    }
}
