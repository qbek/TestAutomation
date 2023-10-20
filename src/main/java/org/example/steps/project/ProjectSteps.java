package org.example.steps.project;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.example.steps.TestDataSteps;

import java.util.Map;

import static org.example.data.TestDataGenerator.createProject;

public class ProjectSteps {

    @Steps
    private ProjectClient client;

    @Steps
    private ProjectVerification verification;

    @Steps(shared = true)
    private TestDataSteps testData;

    @Step
    public void userCreatesProject() {
        var project = createProject();
        testData.setProjectData(project);
        var data = Map.of(
                "projectName", project.getName(),
                "danaNieistniejaca", "aaaa"
        );
       sendCreateProjectRequest(data);
    }

    public void userCreatesProjectWithColor() {
        var project = createProject();
        testData.setProjectData(project);
        var data = Map.of(
                "projectName", project.getName(),
                "*projectColor", "black"
        );
        sendCreateProjectRequest(data);
    }

    private void sendCreateProjectRequest(Map<String, String> data) {
        var project = testData.getProjectData();
        var response = client.postProjects(data, "clientB");
        verification.checkProjectDetails(response, project.getName());
        project.setId(response.then().extract().path("id"));
    }


    @Step("User checks #projectId project details")
    public void userCheckProjectDetails() {
        var project = testData.getProjectData();
        var response = client.getProjects(project.getId());
        verification.checkProjectDetails(response, project.getName());
    }

    @Step
    public void userChecksAllProjectsList() {
        var project = testData.getProjectData();
        var response = client.getProjects();
        verification.checkAllProjectsList(response);
    };



}
