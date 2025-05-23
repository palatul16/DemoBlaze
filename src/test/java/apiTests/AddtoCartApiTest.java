package apiTests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddtoCartApiTest {
	 
    String baseURL = "https://api.demoblaze.com/addtocart";

    @Test
    public void testAddToCart() {
        
        String requestBody = "{\n" +
                "  \"id\": \"514bd6bc-7602-8a95-acd1-bb9e77c8ac62\",\n" +
                "  \"cookie\": \"user=67ca3483-ad00-f4a3-00f7-7c49db9f70bf\",\n" +
                "  \"prod_id\": 1,\n" +
                "  \"flag\": false\n" +
                "}";
 
        Response response =
            given()
                .contentType(ContentType.JSON)  
                .body(requestBody)              
            .when()
                .post(baseURL)                  
            .then()
                .extract().response();          
 
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200!");
 
        Assert.assertEquals(response.getContentType(), "text/html; charset=utf-8", "Content Type mismatch!");
 
        System.out.println("Response: " + response.getBody().asString());
 
        Assert.assertTrue(response.getHeader("server").contains("Google Frontend"), "Unexpected server response!");

        System.out.println("Add to Cart API Test Passed!");
    }
}
