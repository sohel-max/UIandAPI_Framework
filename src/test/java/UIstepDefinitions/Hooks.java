package UIstepDefinitions;
import com.aventstack.extentreports.reporter.FileUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.essntials.driverManager;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import utility.ScreenshotUtil;
import UI.Utils.ScreenshotUtil;

import java.io.File;
import java.io.IOException;

import static org.essntials.driverManager.driver;


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
    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException
    {
if(scenario.isFailed())
{
    File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    byte[] fileContent= FileUtils.readFileToByteArray(sourcePath);
    scenario.attach(fileContent,"image/png","image");
}
    }

}
