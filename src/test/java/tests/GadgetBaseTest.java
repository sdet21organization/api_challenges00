package tests;

import helpers.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

public class GadgetBaseTest {

    static String url = ConfigReader.get("GadgetURL");

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = url;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
