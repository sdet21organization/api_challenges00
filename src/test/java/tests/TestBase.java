package tests;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class TestBase {

    static String url = "https://apichallenges.herokuapp.com";

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI =url;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

}
