package com.visma.tests.rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class BaseService {

    private static RequestSpecification requestSpecification;

    private static String baseUrl = "https://jsonplaceholder.typicode.com";

    public void restAssuredSetUp() {
        requestSpecification = getDefaultSpecBuilder(baseUrl).build();
    }

    public RequestSpecBuilder getDefaultSpecBuilder(String baseUrl) {
        return new RequestSpecBuilder().setBaseUri(baseUrl)
                .setUrlEncodingEnabled(false)
                .setContentType(JSON);
    }

    public ValidatableResponse getRequest(String url) {
        return given().spec(requestSpecification)
                .when()
                .get(url)
                .then()
                .statusCode(200);
    }

}
