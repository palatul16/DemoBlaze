package api;

import io.restassured.RestAssured;

import io.restassured.response.Response;

public class BaseAPI {

    public static Response getRequest(String endpoint) {
        return RestAssured.get(endpoint);
    }

    public static Response postRequest(String endpoint, String body) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(body)
                .post(endpoint);
    }
}
