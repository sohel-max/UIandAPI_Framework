package UIstepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.ExcelUtil;
import static org.essntials.driverManager.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class MultiLoginUsingDataProvider {

    @Then("User navigates to {string} page")
    public void user_navigates_to_page(String string) {

        driver.get("https://the-internet.herokuapp.com" + string);
    }
//we can not use cucubmer with dataprovider.
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        String excelPath = "src/test/testdata/LoginData1.xlsx";
        return ExcelUtil.getTestData(excelPath, "Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();

        WebElement message = driver.findElement(By.id("flash"));
        System.out.println("Login Result for " + username + ": " + message.getText().trim());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}