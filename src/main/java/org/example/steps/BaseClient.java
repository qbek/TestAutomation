package org.example.steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;

public class BaseClient {

    protected RequestSpecBuilder getBaseRequestSpec() {
        return new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer d469ce54eca3a7ca5b6b5e7d4c8d51ced8d4c7b1")
                .setBaseUri("https://api.todoist.com/rest/v2")
                .log(LogDetail.ALL);
    }
}
