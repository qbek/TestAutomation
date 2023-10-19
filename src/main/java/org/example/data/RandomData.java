package org.example.data;

import com.github.javafaker.Faker;
import org.example.data.model.ProjectData;
import org.example.data.model.TaskData;

public class RandomData {

    private static Faker faker = new Faker();

    public static ProjectData getRandomProject() {
        return new ProjectData(faker.witcher().monster());
    }

    public static TaskData getRandomTask() {
        return new TaskData(faker.witcher().quote());
    }
}
