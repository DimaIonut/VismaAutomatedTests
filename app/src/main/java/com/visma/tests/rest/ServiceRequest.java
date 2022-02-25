package com.visma.tests.rest;

import com.visma.tests.model.TypiCodeObject;
import io.restassured.response.Response;

public class ServiceRequest extends BaseService {

    public ServiceRequest() {
        restAssuredSetUp();
    }

    public TypiCodeObject[] getTypiCodeObjectsDetails() {
        return getRequest("posts").log().all().extract().as(TypiCodeObject[].class);
    }
}
