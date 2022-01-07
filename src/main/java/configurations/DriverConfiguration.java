package configurations;

import org.openqa.selenium.NotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverConfiguration {
   private static Properties props = new Properties();
   public static String getMainPageURL (){
       return props.getProperty("URL");
   }
   public static String getBrowserName(){
       return props.getProperty("BROWSER").toLowerCase();
   }
   public static String getExplicitWait(){
       return props.getProperty("EXPLICIT_WAIT");
   }

   public static Integer getExplicitWaitToInt(){
       return Integer.parseInt(getExplicitWait());
   }

   public static String getMaxValueRandomNumbers(){
       return props.getProperty("MAX_VALUE_RANDOM_NUMBERS");
   }
   public static String getSliderXCoordinateValueMin(){
       return props.getProperty("SLIDER_X_COORDINATE_VALUE_MIN");
   }
   public static String getSliderXCoordinateValueMax (){
       return props.getProperty("SLIDER_X_COORDINATE_VALUE_MAX");
   }
   public static String getSliderYCoordinateFinal(){
       return props.getProperty("SLIDER_Y_COORDINATE_FINAL");
   }
   public static String getCheckFrequencyTime(){
       return props.getProperty("CHECK_FREQUENCY_TIME");
   }

   public static Integer getCheckFrequencyTimeToInt(){
       return Integer.parseInt(getCheckFrequencyTime());
   }
   public static String getDimensionXLine(){
       return props.getProperty("DIMENSION_X_LINE");
   }

   public static Integer getDimensionXLineToInt(){
       return Integer.parseInt(getDimensionXLine());
   }
   public static String getDimensionYLine(){
       return props.getProperty("DIMENSION_Y_LINE");
   }
   public static Integer getDimensionYLineToInt(){
       return Integer.parseInt(getDimensionYLine());
   }




    /**
     * Прежде чем обращаться к свойствам их нужно считать из файла.
     * При отсутствии нужных свойств необходимо возбудить исключение,
     * чтобы предотвратить неорреткную работу приложения
     */
    static {
       ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("data.properties");
        try {
            props.load(input);
            String URL = props.getProperty("URL", null);
            String BROWSER = props.getProperty("BROWSER", null);
            String EXPLICIT_WAIT = props.getProperty("EXPLICIT_WAIT");
            String MAX_VALUE_RANDOM_NUMBERS = props.getProperty("MAX_VALUE_RANDOM_NUMBERS");
            String SLIDER_X_COORDINATE_VALUE_MIN = props.getProperty("SLIDER_X_COORDINATE_VALUE_MIN");
            String SLIDER_X_COORDINATE_VALUE_MAX = props.getProperty("SLIDER_X_COORDINATE_VALUE_MAX");
            final String SLIDER_Y_COORDINATE_FINAL = props.getProperty("SLIDER_Y_COORDINATE_FINAL");
            String CHECK_FREQUENCY_TIME = props.getProperty("CHECK_FREQUENCY_TIME");
            String DIMENSION_X_LINE = props.getProperty("DIMENSION_X_LINE");
            String DIMENSION_Y_LINE = props.getProperty("DIMENSION_Y_LINE");
            if (URL == null || BROWSER == null) throw new NotFoundException ("There is no URL or BROWSER in Properties");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("не удалось считать Properties");
        }
        catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}