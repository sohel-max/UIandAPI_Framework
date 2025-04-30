package UIstepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.essntials.driverManager;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
//import utility.ScreenshotUtil;
import UI.Utils.ScreenshotUtil;


public class Hooks {

    @Before
    public void setUp() {
        // Driver initialization is handled lazily in DriverManager
        driverManager.getDriver();

    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = driverManager.getDriver();

        if (scenario.isFailed()) {
            byte[] screenshot = ScreenshotUtil.captureScreenshot(driver);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
            ScreenshotUtil.saveScreenshotToDisk(driver, scenario.getName());

        }

        driverManager.quitDriver();
    }
}
