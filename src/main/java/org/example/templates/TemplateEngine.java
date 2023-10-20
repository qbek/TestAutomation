package org.example.templates;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.objenesis.instantiator.basic.ObjectInputStreamInstantiator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.io.Resources.getResource;
import static java.lang.String.format;
import static java.nio.file.Files.readString;
import static java.nio.file.Path.of;

public class TemplateEngine {

    private static List<RandomData> generators;

    static {
        generators = new ArrayList<>();
        generators.add(new RandomUUIDGenerator());
    }

    public static String getPayloadFromTemplate(String version, String templateName, Map<String, String> data) {
        var template = readTemplateFile(version, templateName);
        template = updateRandomValues(template);
        template = fillData(template, data);
        return removeNotSetEtries(template);
    }

    private static String readTemplateFile(String version, String templateName) {
        try {
            return readString(of(getResource(format("%s/%s.json", version, templateName)).toURI()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static String updateRandomValues(String template) {
        for (var generator : generators) {
            template = generator.replace(template);
        }
        return template;
    }

    private static String fillData(String template, Map<String, String> data) {
        for (var key : data.keySet()) {
            var searchString = format("{{%s}}", key);
            var replaceString = data.get(key);
            template = template.replace(searchString, replaceString);
        }
        return template;
    }

    private static String removeNotSetEtries(String template) {
        template = template.replaceAll("\"?\\{\\{[A-Za-z0-9]+\\}\\}\"?", "null");
        JsonObject json = new Gson().fromJson(template, JsonObject.class);
        return new GsonBuilder().create().toJson(json);
    }
}
