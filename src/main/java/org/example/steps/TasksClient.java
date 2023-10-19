package org.example.steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static io.restassured.http.ContentType.JSON;

public class TasksClient {

    private static final String
            TASKS_PATH = "/tasks",
            TASKS_BY_ID_PATH = "/tasks/{id}";

    public Response postTasks(String name, String projectId) {
        var payload = String.format("{\"content\": \"%s\", \"project_id\": \"%s\"}", name, projectId);
        var request = getBaseRequestSpec()
                .setContentType(JSON)
                .setBody(payload).build();
        return SerenityRest.given().spec(request).post(TASKS_PATH);
    }

    public Response getTasks(String id) {
        var request = getBaseRequestSpec()
                .addPathParam("id", id)
                .build();
        return SerenityRest.given().spec(request).get(TASKS_BY_ID_PATH);
    }

    public Response getTasks() {
        var request = getBaseRequestSpec()
                .build();
        return SerenityRest.given().spec(request).get(TASKS_PATH);
    }


    private RequestSpecBuilder getBaseRequestSpec() {
        return new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer d469ce54eca3a7ca5b6b5e7d4c8d51ced8d4c7b1")
                .setBaseUri("https://api.todoist.com/rest/v2")
                .log(LogDetail.ALL);
    }


}
