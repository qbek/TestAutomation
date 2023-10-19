package org.example.steps;

import io.restassured.response.Response;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.equalTo;

public class TaskVerification {

    public void checkTaskDetails (Response response, String name, String projectId) {
        response.then().log().all()
                .assertThat().statusCode(200)
                .body("content", equalTo(name))
                .body("project_id", equalTo(projectId));
    }

    public void checkTasksList(Response response) {
        response.then().log().all()
                .assertThat().statusCode(200);
    }
}
