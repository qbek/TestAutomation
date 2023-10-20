package org.example.steps.project;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.util.resource.Resource;
import org.example.steps.BaseClient;
import org.example.templates.TemplateEngine;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static io.restassured.http.ContentType.JSON;
import static java.lang.String.format;

public class ProjectClient extends BaseClient {

    private final static String
            PROJECTS_PATH = "/projects",
            PROJECTS_BY_ID_PATH = "/projects/{id}";

    @Step("Send post project with project name {0}")
    public Response postProjects(Map<String, String> data, String version) {

        String payload = TemplateEngine.getPayloadFromTemplate(version, "createProject", data);
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


