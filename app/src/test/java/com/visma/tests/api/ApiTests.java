package com.visma.tests.api;

import com.visma.tests.model.TypiCodeObject;
import com.visma.tests.rest.ServiceRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;

import java.util.Arrays;

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

    @Test
    public void checkTitleExistsTest() {
        String titleValue = "qui est esse";
        when().get("http://jsonplaceholder.typicode.com/posts")
                .then().log().all()
                .statusCode(200)
                .body("title", hasItems(titleValue))
                .log().all();
    }

}