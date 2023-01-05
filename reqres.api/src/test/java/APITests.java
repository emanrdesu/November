import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.matcher.RestAssuredMatchers.*;

import java.util.HashMap;
import org.hamcrest.Matchers;

public class APITests {

    private String index = "https://reqres.in";

    private HashMap<String, String> parameters(String... keyValuePairs) {
        var result = new HashMap<String, String>(); 
        var index = 0; var halfLength = keyValuePairs.length / 2; 

        while(halfLength-- != 0)
            result.put(keyValuePairs[index++], keyValuePairs[index++]);

        return result;
    }

    @Test
    public void canRun() {
        RestAssured.when().
            get(index).
        then().
            statusCode(200);
    }

    @Test
    public void canGetEmailAddress() {
        var route = "/api/users/2";

        var expectedCode = 200;
        var expectedEmail = "janet.weaver@reqres.in";

        RestAssured.given().
            baseUri(index).
        when().
            get(route).
        then().
            statusCode(expectedCode).
            body("data.email", Matchers.equalTo(expectedEmail));
    }
    
    @Test
    public void canGetToken() {
        var route = "/api/register";
        var expectedCode = 200;
        var expectedToken = "QpwL5tke4Pnpja7X4";
        
        var params = parameters(
            "email", "eve.holt@reqres.in",
            "password", "pistol"
        );

        System.out.println(params);
        
        RestAssured.given().
            baseUri(index).
            contentType(ContentType.JSON).
            body(params).
        when().
            post(route).
        then().
            statusCode(expectedCode).
            body("token", Matchers.equalTo(expectedToken));
    }

    @Test
    public void canDelete() {
        var route = "/api/users/2";
        var expectedCode = 204;

        RestAssured.given().
            baseUri(index).
        when().
            delete(route).
        then().
            statusCode(expectedCode);
    }

    
    private void canUpdate(String verb) {
        var expectedCode = 200;
        var expectedName = "morpheus2";
        var route = "/api/users/2";

        Response[] response = new Response[2];

        for(int i = 0; i < 2; i++) {
            var beforeVerb = 
               RestAssured.given().
                    baseUri(index).
                    contentType(ContentType.JSON).
                    body(parameters("name", expectedName)).
               when();

            var atVerb = (verb == "put") ? beforeVerb.put(route) : beforeVerb.patch(route);

            response[i] = atVerb.
                then().
                    statusCode(expectedCode).
                    body("name", Matchers.equalTo(expectedName)).
                extract().
                    response();
        }

        String timeStamp1 = response[0].path("updatedAt");
        String timeStamp2 = response[0].path("updatedAt");
        Assert.assertTrue(timeStamp1.compareTo(timeStamp2) <= 0, "Update expected");
    }

    @Test
    public void canPatch() {
        canUpdate("patch");
    }

    @Test
    public void canPut() {
        canUpdate("put");
    }
}