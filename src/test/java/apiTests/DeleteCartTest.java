package apiTests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class DeleteCartTest {
	String baseURL = "https://api.demoblaze.com/deletecart";

    @Test
    public void testDeleteCart() {
        
        String requestBody = "{\n" +
                "  \"cookie\": \"user=67ca3483-ad00-f4a3-00f7-7c49db9f70bf\"\n" +
                "}";

        // Send POST request
        Response response =
            given()
                .contentType(ContentType.JSON) // Setting JSON type
                .body(requestBody)             // Sending request payload
            .when()
                .post(baseURL)                 // Hitting API endpoint
            .then()
                .extract().response();         // Extracting response

         
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200!");

         
        Assert.assertTrue(response.getContentType().contains("application/json"), "Content Type mismatch!");

        
        System.out.println("Response: " + response.getBody().asString());

         
        Assert.assertTrue(response.getBody().asString().contains("Item deleted."), "Item was not deleted!");

        System.out.println("Delete Cart API Test Passed!");
    
 }
}
