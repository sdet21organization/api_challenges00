package tests;

import helpers.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;

public class ReqresBaseTest {

    static String url = ConfigReader.get("ReqresURL");

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = url;
        RestAssured.given().header("x-api-key","reqres-free-v1");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
