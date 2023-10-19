package org.example.data;

import org.example.data.model.ProjectData;
import org.example.data.model.TaskData;

import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {

    private static List<DataGenerator> generators;

    static {
        generators = new ArrayList<>();
        generators.add(new RandomData());
        generators.add(new StaticData());
    }

    public static ProjectData createProject() {
        return getGenerator().getProject();
    }

    public static TaskData createTask() {
        return getGenerator().getTask();
    }

    private static DataGenerator getGenerator () {
        var dataType= System.getProperty("data", "static");
        for (DataGenerator generator : generators) {
            if (generator.getType().equals(dataType)) {
                return generator;
            }
        }
        throw new RuntimeException("Invalid data type");
    }
}
