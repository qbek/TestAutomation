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
    public Response postProjects(Map<String, String> data) {

        String payload = null;
        try {
            payload = Files.readString(Path.of(Resources.getResource("clientB/createProject.json").toURI()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        for (var key : data.keySet()) {
            var searchString = format("{{%s}}", key);
            var replaceString = data.get(key);
            payload = payload.replace(searchString, replaceString);
        }

        payload = payload.replaceAll("\"?\\{\\{[A-Za-z0-9]+\\}\\}\"?", "null");

        JsonObject json = new Gson().fromJson(payload, JsonObject.class);
        payload = new GsonBuilder().create().toJson(json);

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


