package wrappers;

import dto.gadget.Gadget;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class ApiWrapper {

    public static Gadget createGadget(Gadget gadgetToCreate) {
        return given()
                .body(gadgetToCreate)
                .contentType(ContentType.JSON)
                .when()
                .post("/objects")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().as(Gadget.class);
    }
}
