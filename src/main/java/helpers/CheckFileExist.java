package helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class CheckFileExist {
public static Logger logger = LogManager.getLogger();


   public static boolean isFileExist(String filePathString){
       logger.info("этот метод проверяет наличие файла по указанному пути и указанному имени");
       File f = new File(filePathString);
       if(f.exists() && !f.isDirectory()) {
           return true;
       }else
       return false;
    }

}
