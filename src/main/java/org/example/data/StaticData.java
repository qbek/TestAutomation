package org.example.data;

import org.example.data.model.ProjectData;
import org.example.data.model.TaskData;

public class StaticData {

    public static ProjectData getStaticProject() {
        return new ProjectData("Statyczna nazwa");
    }

    public static TaskData getStaticTask() {
        return new TaskData("To jest moje zadanie");
    }
}
