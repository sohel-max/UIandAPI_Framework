package UIstepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.essntials.PropClass;
import org.essntials.driverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;

import static UI.Utils.Utility.tabSwitch;
//import static stepDefinitions.Common.driver;

public class multiBrowserTabTest {
    WebDriver driver = driverManager.getDriver();
    @Test
    @Given("User is redirect to website")
    public void user_is_redirect_to_website() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }
    @When("User clicks on multiWin and click here link")
    public void openMultipleWindows() throws IOException {
        PropClass.loadFile();
        driver.findElement(By.xpath(PropClass.get("MultiWinLink"))).click();

        driver.findElement(By.xpath(PropClass.get("ClickHereOnPage"))).click();
        //


    }
    @Then("User verify title")

    public void verifyTitle()  {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       // tabSwitch();
        String actualTitle = driver.getTitle();
        String expectedTitle="New Window";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");


    }
}

