import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers;

public class APITests {
    
    private String index = "https://reqres.in";  
    
    @Test
    public void canRun() {
        RestAssured.when().
            get(index).
        then().
            statusCode(200);
    }
    
    @Test
    public void canGetEmailAddress() {
        var expectedEmail = "janet.weaver@reqres.in";

        RestAssured.when().
            get(index + "/api/users/2").
        then().
            statusCode(200).
            body("data.email", Matchers.equalTo(expectedEmail));
    }
}