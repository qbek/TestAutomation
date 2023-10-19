package org.example.steps;

import com.ibm.icu.util.StringTrieBuilder;
import io.restassured.RestAssured;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.example.data.ProjectData;
import org.hamcrest.Matchers;

import static io.restassured.http.ContentType.JSON;

public class ProjectSteps {

    private ProjectData project;

    @Steps
    private ProjectClient client;

    @Steps
    private ProjectVerification verification;

    @Step
    public void userCreatesProject() {
        project = new ProjectData("Moja nazwa projektu");
        var response = client.postProjects(project.getName());
        verification.checkProjectDetails(response, project.getName());
        project.setId(response.then().extract().path("id"));
    }

    @Step("User checks #projectId project details")
    public void userCheckProjectDetails() {
        var response = client.getProjects(project.getId());
        verification.checkProjectDetails(response, project.getName());
    }

    @Step
    public void userChecksAllProjectsList() {
        var response = client.getProjects();
        verification.checkAllProjectsList(response);
    };
}