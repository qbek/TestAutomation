package org.example.data;

import org.example.data.model.ProjectData;
import org.example.data.model.TaskData;

public class StaticData implements DataGenerator {

    @Override
    public ProjectData getProject() {
        return new ProjectData("Statyczna nazwa");
    }

    @Override
    public TaskData getTask() {
        return new TaskData("To jest moje zadanie");
    }

    @Override
    public String getType() {
        return "static";
    }
}
