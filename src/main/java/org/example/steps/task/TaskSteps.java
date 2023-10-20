package org.example.steps.task;

import net.serenitybdd.annotations.Steps;
import org.example.data.TestDataGenerator;
import org.example.steps.TestDataSteps;

public class TaskSteps {

    @Steps
    TasksClient client;

    @Steps
    TaskVerification verification;

    @Steps(shared = true)
    TestDataSteps testData;

    public void userAddsTaskToTheProject() {
        var task = TestDataGenerator.createTask();
        var project = testData.getProjectData();
        task.setProjectId(project.getId());
        var response = client.postTasks(task.getName(), task.getProjectId());
        verification.checkTaskDetails(response, task.getName(), task.getProjectId());
        task.setId(response.then().extract().path("id"));
        testData.setTaskData(task);
    }

    public void userChecksTaskDetails() {
        var task = testData.getTaskData();
        var response = client.getTasks(task.getId());
        verification.checkTaskDetails(response, task.getName(), task.getProjectId());
    }

    public void userChecksTasksList() {
        var response = client.getTasks();
        verification.checkTasksList(response);
    }
}
