package org.example.steps.po;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject {

    private static final By
            EMAIL = By.cssSelector("#element-0"),
            PASSWORD = By.cssSelector("#element-3"),
            BUTTON = By.cssSelector("[type=\"submit\"]");

    @Step
    public void enterEmail(String email) {
        find(EMAIL).type(email);
    }

    @Step
    public void enterPassword(String password) {
        find(PASSWORD).type(password);
    }

    @Step
    public void clickLoginButton() {
        find(BUTTON).click();
    }

    @Step
    public void fullFormFill(String email, String password) {
//        find(EMAIL).typeAndTab(email);
        find(By.cssSelector(":focus")).typeAndTab(email);
        find(By.cssSelector(":focus")).typeAndEnter(password);
    }
}
