package org.example.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.example.steps.po.LoginForm;
import org.example.steps.po.TodoistApp;

public class SeleniumSteps {

    @Steps
    TodoistApp app;

    @Steps
    LoginForm login;


    @Step
    public void userOpensLoginPage() {
        app.openLoginPage();
    }

    @Step
    public void userEntersValidCredentials() {
//        login.loginUser("gbinxeqerpnywwysux@awdrt.org", "ti4FCvBL39i7mMq");
//        login.enterEmail("gbinxeqerpnywwysux@awdrt.org");
//        login.enterPassword("ti4FCvBL39i7mMq");
//        login.clickLoginButton();

        login.fullFormFill("gbinxeqerpnywwysux@awdrt.org", "ti4FCvBL39i7mMq");

    }

    @Step
    public void userIsLoggedIn() {
        app.waitForGlassToClose();
        app.storeCookie();
    }

    public void userOpensMainPage() {
        app.openMainPage();
        app.waitForGlassToClose();
    }
}
