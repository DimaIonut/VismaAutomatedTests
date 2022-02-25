package com.visma.tests.api;

import com.visma.tests.model.TypiCodeObject;
import com.visma.tests.rest.ServiceRequest;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;

public class ApiTests {

    private final ServiceRequest serviceRequest = new ServiceRequest();

    private final String content = "qui est esse";

    @Test
    public void existPostWithCertainTitle() {

        Arrays.stream(serviceRequest.getTypiCodeObjectsDetails()).forEach(typiCodeObject -> {
            if(typiCodeObject.getTitle().equals(content)) {
                Assertions.assertTrue(typiCodeObject.getTitle().contains(content));
            }
        });
    }

    //Alin
    @Test
    public void checkTitleExistsTest() {
        String titleValue = "qui est esse";
        when().get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200)
                .body("title", hasItems(titleValue))
                .log().all();
    }
}