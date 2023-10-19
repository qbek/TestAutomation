package org.example.steps;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.example.data.TestDataGenerator;
import org.example.data.model.ProjectData;
import org.example.data.model.TaskData;

public class TaskSteps {

    @Steps
    TasksClient client;

    @Steps
    TaskVerification verification;

    private TaskData task;

    public void userAddsTaskToTheProject() {
        task = TestDataGenerator.createTask();
        var project = (ProjectData) Serenity.sessionVariableCalled("projectData");
        task.setProjectId(project.getId());
        var response = client.postTasks(task.getName(), task.getProjectId());
        verification.checkTaskDetails(response, task.getName(), task.getProjectId());
        task.setId(response.then().extract().path("id"));
    }

    public void userChecksTaskDetails() {
        var response = client.getTasks(task.getId());
        verification.checkTaskDetails(response, task.getName(), task.getProjectId());
    }

    public void userChecksTasksList() {
        var response = client.getTasks();
        verification.checkTasksList(response);
    }
}
