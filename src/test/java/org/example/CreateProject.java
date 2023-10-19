package org.example;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.WithTag;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.example.steps.ProjectSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class CreateProject {

    @Steps
    ProjectSteps steps;

    @Test
    @WithTag("issue:PRJ-1234")
    public void userCanCreateANewProject() {
        steps.userCreatesProject();
        steps.userCheckProjectDetails();
        steps.userChecksAllProjectsList();
    }

}
