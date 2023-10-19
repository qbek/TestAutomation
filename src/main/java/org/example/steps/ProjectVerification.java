package org.example.steps;

import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;

public class ProjectVerification {

    @Step("Check if project has correct name: {1}")
    public void checkProjectDetails(Response response, String expectedName) {
        response.then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("name", Matchers.equalTo(expectedName));
    }

    @Step
    public void checkAllProjectsList(Response response) {
        response.then().log().all()
                .assertThat().statusCode(200);
    }
}
