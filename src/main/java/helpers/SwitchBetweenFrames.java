package helpers;

import static driver.DriverFactory.getDriver;

public class SwitchBetweenFrames {

    /**
     * Числа 0 и 1 в константы не выносим
     */

    public static void switchToRootFrame(){
        getDriver().switchTo().frame(0);
    }

    public static void switchToSecondFrame(){
        getDriver().switchTo().frame(1);
    }

}
