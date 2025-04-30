package API_Utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class APIUtils {

    public static Response get(String baseURI, String endpoint) {
        return given()
                .baseUri(baseURI)
                .header("Content-Type", "application/json")
                .get(endpoint);
    }


}
