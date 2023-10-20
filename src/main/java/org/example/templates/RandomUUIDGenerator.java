package org.example.templates;

import com.github.javafaker.Faker;

public class RandomUUIDGenerator implements RandomData {

    private static final String SEARCH_STRING = "{{$guid}}";
    @Override
    public String replace(String template) {
        return template.replace(SEARCH_STRING, Faker.instance().internet().uuid());
    }


}
