package org.example;
import net.serenitybdd.annotations.Steps;
//import net.serenitybdd.annotations.WithTTag;
import org.example.steps.project.ProjectSteps;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class CreateProject extends Base {

    @Steps
    ProjectSteps steps;

    @Test
    @Tag("issue:PRJ-1234")
    public void userCanCreateANewProject() {
        steps.userCreatesProject();
        steps.userCheckProjectDetails();
    }

    public void userCanCreateProjectWithColor() {
        steps.userCreatesProjectWithColor();
    }

    @Test
    public void userCanGetAllProjectsList() {
        steps.userCreatesProject();
        steps.userChecksAllProjectsList();
    }

}
