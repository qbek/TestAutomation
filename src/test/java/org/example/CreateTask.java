package org.example;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.example.precondition.ProjectPrecondition;
import org.example.steps.ProjectSteps;
import org.example.steps.TaskSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


public class CreateTask extends Base {

    @Steps
    private ProjectPrecondition preconditions;

    @Steps
    private TaskSteps steps;


    @Test
    public void userAddsTaskToTheProject() {
        preconditions.userHasProjectCreated();
        steps.userAddsTaskToTheProject();
        steps.userChecksTaskDetails();
    }

    @Test
    public void userChecksTasksList() {
        preconditions.userHasProjectCreated();
        steps.userAddsTaskToTheProject();
        steps.userChecksTasksList();
    }


}
