package org.example.data;

import org.example.data.model.ProjectData;
import org.example.data.model.TaskData;

public class TestDataGenerator {

    public static ProjectData createProject() {
        var dataType= System.getProperty("data", "static");
        if (dataType.equals("static")) {
            return StaticData.getStaticProject();
        } else if (dataType.equals("random")) {
            return RandomData.getRandomProject();
        } else {
            throw new RuntimeException("Invalid data type");
        }
    }

    public static TaskData createTask() {
        var dataType= System.getProperty("data", "static");
        if (dataType.equals("static")) {
            return StaticData.getStaticTask();
        } else if (dataType.equals("random")) {
            return RandomData.getRandomTask();
        } else {
            throw new RuntimeException("Invalid data type");
        }
    }
}
