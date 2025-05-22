package API_StepDefns;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import API_Utils.APIUtils;
import API_Utils.ConfigReader;

import static org.hamcrest.Matchers.*;

public class LoginStepDef {

    Response response;
    String baseURI;

    @Given("the API is available")
    public void login_api_available() {
        baseURI = ConfigReader.get("baseURI");
    }

    @When("List of existing user")
    public void listExistingUser() {

        response = APIUtils.get(baseURI, "/api/users");
    }

    @Then("Verify Status code")
    public void validate_response_Code() {
        response.then().statusCode(200);

    }
}
