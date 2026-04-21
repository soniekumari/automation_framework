package api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class AuthTest extends BaseAPI {

    public static String token;
    public static int userId;

    public static void login() {
        Response res =
                given()
                        .contentType("application/json")
                        .body("{\"username\":\"emilys\",\"password\":\"emilyspass\"}")
                        .when()
                        .post("/auth/login");

        System.out.println(res.asPrettyString());

        res.then().statusCode(200);

        // Extract authentication token and user ID from API response
        token = res.jsonPath().getString("accessToken");
        userId = res.jsonPath().getInt("id");

        // Assertions
        assert token != null && !token.isEmpty();
        assert userId > 0;

        // Debug prints
        System.out.println("Token: " + token);
        System.out.println("UserId: " + userId);
    }
}