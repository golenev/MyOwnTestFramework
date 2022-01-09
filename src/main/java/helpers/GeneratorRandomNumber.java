package helpers;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

public class GeneratorRandomNumber {
    public static Logger logger = LogManager.getLogger();

    public static int getRandomNumberUsingInts(int min, int max) {
    logger.info("метод генерирует случайные в заданном диапазоне от " + min + " до " + max);
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
}
