package specs;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class ChallengesSpecs {

    public static RequestSpecification defaultSpec = with()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON)
            .log()
            .all();
}
