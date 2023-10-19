package org.example.data;

import com.github.javafaker.Faker;
import org.example.data.model.ProjectData;
import org.example.data.model.TaskData;

public class RandomData implements DataGenerator {

    private static Faker faker = new Faker();

    @Override
    public ProjectData getProject() {
        return new ProjectData(faker.witcher().monster());
    }

    @Override
    public TaskData getTask() {
        return new TaskData(faker.witcher().quote());
    }

    @Override
    public String getType() {
        return "random";
    }
}
