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

    @Step
    public void userCreatesProject() {
        var project = createProject();
        Serenity.setSessionVariable("projectData").to(project);
        var response = client.postProjects(project.getName());
        verification.checkProjectDetails(response, project.getName());
        project.setId(response.then().extract().path("id"));
    }

    @Step("User checks #projectId project details")
    public void userCheckProjectDetails() {
        var project = (ProjectData) Serenity.sessionVariableCalled("projectData");
        var response = client.getProjects(project.getId());
        verification.checkProjectDetails(response, project.getName());
    }

    @Step
    public void userChecksAllProjectsList() {
        var project = (ProjectData) Serenity.sessionVariableCalled("projectData");
        var response = client.getProjects();
        verification.checkAllProjectsList(response);
    };

}
