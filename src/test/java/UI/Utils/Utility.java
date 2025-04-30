package UI.Utils;

import java.util.Iterator;
import java.util.Set;

import static org.essntials.driverManager.driver;

public class Utility {
    public static void tabSwitch() {
        String mainWin = driver.getWindowHandle();
        Set<String> c = driver.getWindowHandles();
        Iterator<String> l = c.iterator();
        while (l.hasNext()) {
            String childWin = l.next();
            if (!mainWin.equalsIgnoreCase(childWin)) {
                driver.switchTo().window(childWin);
            }

        }

        }}