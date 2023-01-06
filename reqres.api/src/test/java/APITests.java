import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
        String timeStamp2 = response[1].path("updatedAt");
        Assert.assertTrue(timeStamp1.compareTo(timeStamp2) < 0, "Update expected");
    }

    @Test
    public void canPatch() {
        canUpdate("patch");
    }

    @Test
    public void canPut() {
        canUpdate("put");
    }

    @Test
    public void canDeserialize() {
        var route = "/api/users/2";

        var expectedCode = 200;

        var expectedID = 2;
        var expectedEmail = "janet.weaver@reqres.in";
        var expectedFirstName = "Janet";
        var expectedLastName = "Weaver";
        var expectedAvatar = "https://reqres.in/img/faces/2-image.jpg";

        var expectedURL = "https://reqres.in/#support-heading";
        var expectedText = "To keep ReqRes free, contributions towards server costs are appreciated!";

        Response response = 
                RestAssured.given().
                    baseUri(index).
                    contentType("application/json").
                when().
                    get(route).
                then().
                    statusCode(expectedCode).
                extract().
                    response();

        User user = response.as(User.class);

        Assert.assertEquals(user.getData().getId(), expectedID, "id expected");
        Assert.assertEquals(user.getData().getEmail(), expectedEmail, "email expected");
        Assert.assertEquals(user.getData().getFirst_name(), expectedFirstName, "first name expected");
        Assert.assertEquals(user.getData().getLast_name(), expectedLastName, "last name expected");
        Assert.assertEquals(user.getData().getAvatar(), expectedAvatar, "avatar expected");

        Assert.assertEquals(user.getSupport().getURL(), expectedURL, "url expected");
        Assert.assertEquals(user.getSupport().getText(), expectedText, "text expected");
     }
    
    @Test
    public void canDeserializeUsers() {
        var route = "/api/users?page=2";
        var expectedCode = 200;

        var expectedPage = 2;
        var expectedPerPage = 6;
        var expectedTotal = 12;
        var expectedTotalPages = 2;
        var expectedURL = "https://reqres.in/#support-heading";
        var expectedText = "To keep ReqRes free, contributions towards server costs are appreciated!";

        Response response = 
                RestAssured.given().
                    baseUri(index).
                    contentType("application/json").
                when().
                    get(route).
                then().
                    statusCode(expectedCode).
                extract().
                    response();

        UserList userList = response.as(UserList.class);

        Assert.assertEquals(userList.getPage(), expectedPage, "page expected");
        Assert.assertEquals(userList.getPer_page(), expectedPerPage, "per page expected");
        Assert.assertEquals(userList.getTotal(), expectedTotal, "total expected");
        Assert.assertEquals(userList.getTotal_pages(), expectedTotalPages, "total pages expected");

        Assert.assertEquals(userList.getSupport().getURL(), expectedURL, "url expected");
        Assert.assertEquals(userList.getSupport().getText(), expectedText, "text expected");
    }
}