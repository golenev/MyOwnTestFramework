package configurations;

import org.assertj.core.api.Assert;
import org.openqa.selenium.NotFoundException;

import javax.security.auth.login.Configuration;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverConfiguration {
   public static Properties props = new Properties();

    static   {
       ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("data.properties");
        try {
            props.load(input);
            String URL = props.getProperty("URL", null);
            String BROWSER = props.getProperty("BROWSER", null);
            if (URL == null || BROWSER == null) throw new NotFoundException ("There is no URL or BROWSER in Properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}