package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ReqresJsonPathTest extends ReqresBaseTest {

    @Test
    public void testJsonPath() {
        String userId = "1";
        given().pathParam("userId", userId)
                .when()
                .get("api/users/{userId}")
                .then()
                .assertThat()
                .statusCode(401)
                .contentType(ContentType.JSON)
                .body("data.id", equalTo(1))
                .body("support.text", containsString("Let Content Caddy"))
                .body("data.id", greaterThan(0))
                .body("data.id", lessThan(2))
                .body("data.email", matchesRegex("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"));
    }
}