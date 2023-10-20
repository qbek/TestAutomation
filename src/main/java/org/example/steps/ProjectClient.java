package org.example.steps;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static io.restassured.http.ContentType.JSON;

public class ProjectClient extends BaseClient {

    private final static String
            PROJECTS_PATH = "/projects",
            PROJECTS_BY_ID_PATH = "/projects/{id}";

    @Step("Send post project with project name {0}")
    public Response postProjects(String name) {
        var payload = String.format("{\"name\": \"%s\"}", name);
        var request = getBaseRequestSpec()
                .setContentType(JSON)
                .setBody(payload).build();
        return SerenityRest.given().spec(request).post(PROJECTS_PATH);
    }

    @Step
    public Response getProjects(String id) {
        var request = getBaseRequestSpec()
                .addPathParam("id", id)
                .build();
        return SerenityRest.given().spec(request).get(PROJECTS_BY_ID_PATH);
    }

    @Step
    public Response getProjects() {
        var request = getBaseRequestSpec().build();
        return SerenityRest.given().spec(request).get(PROJECTS_PATH);
    }


}


