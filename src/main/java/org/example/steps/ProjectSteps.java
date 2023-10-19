package org.example.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import org.example.data.model.ProjectData;
import org.example.data.model.TaskData;

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
        var response = client.postProjects(project.getName());
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
