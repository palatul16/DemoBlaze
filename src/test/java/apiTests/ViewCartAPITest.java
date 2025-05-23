package apiTests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ViewCartAPITest {

 
    String baseURL = "https://api.demoblaze.com/viewcart";

    @Test
    public void testViewCart() {
 
        String requestBody = "{\n" +
                "  \"cookie\": \"user=67ca3483-ad00-f4a3-00f7-7c49db9f70bf\",\n" +
                "  \"flag\": false\n" +
                "}";

        // Send POST request
        Response response =
            given()
                .contentType(ContentType.JSON)  
                .body(requestBody)              
            .when()
                .post(baseURL)                  
            .then()
                .extract().response();         
 
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200!");
 
        Assert.assertTrue(response.getContentType().contains("application/json"), "Content Type mismatch!");
 
        System.out.println("Response: " + response.getBody().asString());
 
        Assert.assertTrue(response.getBody().asString().contains("prod_id"), "Cart does not contain any products!");

        System.out.println(" View Cart API Test Passed!");
    }
}
