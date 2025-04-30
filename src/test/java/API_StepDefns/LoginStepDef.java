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

    @When("Create a new user")
    public void login_with_valid_credentials() {
        String payload = "{ \"name\": \"John Doe\", \"job\": \"Software Engineer\" }";
        response = APIUtils.get(baseURI, "/api/users", payload);
    }

    @Then("Verify Status code")
    public void validate_token_response() {
        response.then().statusCode(200);

    }
}
