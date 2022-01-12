package com.visma.tests.api;

import com.visma.tests.model.TypiCodeObject;
import com.visma.tests.rest.ServiceRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}