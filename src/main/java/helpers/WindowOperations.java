package helpers;

import elements.Button;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

import static driver.DriverFactory.getDriver;

public class WindowOperations {
    public static Logger logger = LogManager.getLogger();

    /**
     * Оказавшись на новой вкладке - закрыть предыдущую
     *
     * @param button
     * @return
     */
    public static String clickAndClosePrevious(Button button) {
        return getWindowByClickedLink(button, true, true, false);
    }

    /**
     * Щёлкнув по ссылке, перейти на открывшуюся вкладку и закрыть все остальные
     *
     * @param button
     * @return
     */

    public static String clickSwitchAndCloseAll(Button button) {
        return getWindowByClickedLink(button, true, false, true);
    }

    /**
     * Щёлкнув по ссылке, остаться на текущей вкладке и закрыть все остальные
     *
     * @param button
     * @return
     */

    public static String clickAndCloseAll(Button button) {
        logger.info("открывает новое окно и закрывает его");
        return getWindowByClickedLink(button, false, false, true);
    }

    /**
     * Вернуть описатель/дескриптор текущей вкладки/окна после щелчка
     *
     * @param button
     * @return
     */
    public static String getWindowByClickedLink(Button button) {
        return getWindowByClickedLink(button, false, false, false);
    }

    /**
     * универсальный метод для возвращения дескриптора и навигации по вкладкам.
     * Он напрямую не исользуется, а только для вызова с разными параметрами. Примеры выше
     *
     * @param button
     * @param switchToTarget
     * @param closePrevious
     * @param closeAll
     * @return
     */

    private static String getWindowByClickedLink(Button button, boolean switchToTarget, boolean closePrevious, boolean closeAll) {
        String currentWindow = getDriver().getWindowHandle();
        button.click();
        String targetWindow = getDriver().getWindowHandle();
        if (closeAll) {
            Set<String> windows = getDriver().getWindowHandles();
            if (switchToTarget) {
                currentWindow = targetWindow;

            }
            for (String window : windows) {
                if (window.equals(currentWindow)) continue;
                getDriver().switchTo().window(window).close();
            }
            getDriver().switchTo().window(currentWindow);
            return currentWindow;
        }
        if (closePrevious) {
            getDriver().switchTo().window(currentWindow).close();
            getDriver().switchTo().window(targetWindow);
            return targetWindow;
        }
        if (switchToTarget && !currentWindow.equals(targetWindow)) {
            getDriver().switchTo().window(targetWindow);
            return targetWindow;
        }
        return currentWindow;

    }

}
