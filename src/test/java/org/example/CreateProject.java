package org.example;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.WithTag;
import org.example.steps.project.ProjectSteps;
import org.junit.jupiter.api.Test;


public class CreateProject extends Base {

    @Steps
    ProjectSteps steps;

    @Test
    @WithTag("issue:PRJ-1234")
    public void userCanCreateANewProject() {
        steps.userCreatesProject();
        steps.userCheckProjectDetails();
    }

    @Test
    public void userCanGetAllProjectsList() {
        steps.userCreatesProject();
        steps.userChecksAllProjectsList();
    }

}
