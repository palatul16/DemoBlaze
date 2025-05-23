package apiTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.BaseAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginApiTest {

	String baseUrl = "https://api.demoblaze.com/"; 

    @Test
    public void testValidLogin() {
    	String loginUrl = baseUrl+"/check";
        String requestBody = "{ \"username\": \"atul@gmail.com\", \"password\": \"12345\" }";

        Response response = BaseAPI.postRequest(loginUrl, requestBody);
 
        Assert.assertEquals(response.getStatusCode(), 200);
 
        Assert.assertTrue(response.getBody().asString().contains("token"));

        System.out.println("Login API Test Passed!");
    }

    @Test
    public void testInvalidLogin() {
    	String loginUrl = baseUrl+"/login";
    	 String requestBody = "{ \"username\": \"oire\", \"password\": \"9348nf\" }";

         Response response = BaseAPI.postRequest(loginUrl, requestBody);

         // Validate Status Code (Should be 401 or 400 based on API design)
         Assert.assertEquals(response.getStatusCode(), 401, "Expected status code 401 for invalid login");
         System.out.println(response.getStatusCode());
         // Extract JSON Response
         JsonPath jsonResponse = response.jsonPath();

         // Validate Error Message
         String errorMessage = jsonResponse.getString("errorMessage");
         Assert.assertEquals(errorMessage, "Wrong password.", "Error message did not match!");

         System.out.println("✅ Invalid Login Test Passed!");
    }
}
