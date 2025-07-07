package tests;

import dto.ChallengesResponse;
import dto.Todos;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ChallengesTests extends TestBase {


    static String xChallengerHeader = "";


    @BeforeAll
    static void beforeAll() {
        Response response =
                given()

                        .when()
                        .post("/challenger")

                        .then()
                        .statusCode(201)
                        .extract().response();

        xChallengerHeader = response.header("X-Challenger");

    }

    @Test
    void xChallengerHeaderIsNotEmpty() {

        Assertions.assertNotNull(xChallengerHeader, "x-challenger header is null");
        Assertions.assertNotEquals(xChallengerHeader, "", "x-challenger header is empty");
        Assertions.assertTrue(xChallengerHeader.length() > 10, "x-challenger header lenghth is less than 10");

    }

    @Test
    void getChallengesAndCheckThatFirstTwoAreDone() {
        ExtractableResponse response =
                given()
                        .header("X-Challenger", xChallengerHeader)

                        .when()
                        .get("/challenges")

                        .then()
                        .statusCode(200)
                        .extract();

        ChallengesResponse challengesResponse = response.as(ChallengesResponse.class);


        Assertions.assertEquals(challengesResponse.getChallenges().get(0).getName(), "POST /challenger (201)");
        Assertions.assertTrue(challengesResponse.getChallenges().get(0).isStatus());

        Assertions.assertEquals(challengesResponse.getChallenges().get(1).getName(), "GET /challenges (200)");
        Assertions.assertTrue(challengesResponse.getChallenges().get(1).isStatus());

    }

    @Test
    void getTodos() {
        ExtractableResponse response =
                given()
                        .header("X-Challenger", xChallengerHeader)

                        .when()
                        .get("/todos")

                        .then()
                        .statusCode(200)
                        .extract();

        Todos todossResponse = response.as(Todos.class);

        Assertions.assertFalse(todossResponse.getTodos().get(0).isDoneStatus());
        Assertions.assertFalse(todossResponse.getTodos().get(1).isDoneStatus());
        Assertions.assertTrue(todossResponse.getTodos().size() > 5);

    }

    @Test
    void getTodo2() {
        ExtractableResponse response =
                given()
                        .header("X-Challenger", xChallengerHeader)

                        .when()
                        .get("/todos/2")

                        .then()
                        .statusCode(200)
                        .body(matchesJsonSchemaInClasspath("schemas/todos_response.json"))
                        .extract();

        Todos todossResponse = response.as(Todos.class);

        Assertions.assertEquals(todossResponse.getTodos().get(0).getId(), 2, "Todo ID is not 2");
        Assertions.assertEquals(todossResponse.getTodos().get(0).getTitle(), "file paperwork", "Todo title is not as expected");
        Assertions.assertEquals(todossResponse.getTodos().get(0).getDescription(), "", "Todo description is not as expected");
        Assertions.assertFalse(todossResponse.getTodos().get(0).isDoneStatus());



    }



}
