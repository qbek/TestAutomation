package org.example.data;

import org.example.data.model.ProjectData;
import org.example.data.model.TaskData;

public interface DataGenerator {
    ProjectData getProject();
    TaskData getTask();
    String getType();
}
