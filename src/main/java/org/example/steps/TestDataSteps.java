package org.example.steps;

import net.serenitybdd.core.Serenity;
import org.example.data.model.ProjectData;
import org.example.data.model.TaskData;

public class TestDataSteps {

    private ProjectData projectData;
    private TaskData taskData;

    public ProjectData getProjectData() {
        return projectData;
    }

    public void setProjectData(ProjectData projectData) {
        this.projectData = projectData;
    }

    public TaskData getTaskData() {
        return taskData;
    }

    public void setTaskData(TaskData taskData) {
        this.taskData = taskData;
    }
}
