import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

public class APITests {
    @Test
    public void canRun() {
        RestAssured.when().
            get("https://reqres.in/").
        then().
            statusCode(200);
    }
}