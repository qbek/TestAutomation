package org.example;

import net.serenitybdd.annotations.Steps;
import org.example.precondition.ProjectPrecondition;
import org.example.steps.task.TaskSteps;
import org.junit.jupiter.api.Test;


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
