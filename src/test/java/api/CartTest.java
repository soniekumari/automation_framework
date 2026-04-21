package api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

public class CartTest extends AuthTest {

    @Test
    public void completeAPIFlow() {

        login();

        // Get cart (handle 200 / 404)
        int cartStatus =
                given()
                        .when()
                        .get("/carts/user/" + userId)
                        .then()
                        .extract()
                        .statusCode();

        assertTrue(cartStatus == 200 || cartStatus == 404);

        // Add product
        given()
                .contentType("application/json")
                .body("{\"userId\":" + userId + ",\"products\":[{\"id\":1,\"quantity\":2}]}")
                .when()
                .post("/carts/add")
                .then()
                .statusCode(anyOf(is(200), is(201)))
                .body("products[0].id", equalTo(1))
                .body("products[0].quantity", equalTo(2))
                .body("total", greaterThan(0.0f))
                .body(matchesJsonSchemaInClasspath("schema.json"));
    }
}