package org.example.precondition;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.example.steps.project.ProjectSteps;

public class ProjectPrecondition {

    @Steps
    private ProjectSteps steps;


    @Step
    public void userHasProjectCreated() {
        steps.userCreatesProject();
        steps.userCheckProjectDetails();
    }
}
