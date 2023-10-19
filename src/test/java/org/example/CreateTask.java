package org.example;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.example.steps.ProjectSteps;
import org.example.steps.TaskSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class CreateTask  {

    @Steps
    private ProjectSteps preconditions;

    @Steps
    private TaskSteps steps;


    @Test
    public void userAddsTaskToTheProject() {
        preconditions.userCreatesProject();
        preconditions.userCheckProjectDetails();

        steps.userAddsTaskToTheProject();
        steps.userChecksTaskDetails();
        steps.userChecksTasksList();

    }


}
