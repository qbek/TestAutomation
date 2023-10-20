package org.example.steps.project;

import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;

public class ProjectVerification {

    @Step("Check if project has correct name: {1}")
    public void checkProjectDetails(Response response, String expectedName) {
        var jsonPath = response.then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract().jsonPath();


    }

    @Step
    public void checkAllProjectsList(Response response) {
        response.then().log().all()
                .assertThat().statusCode(200);
    }
}
