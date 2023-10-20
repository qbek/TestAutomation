package org.example.steps.po;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
import org.example.CookieMonster;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

public class TodoistApp extends PageObject {



    private static final By
        LOADING_GLASS = By.cssSelector(".loading"),
        TOP_BAR = By.cssSelector("[data-testid=\"top_bar\"]");

    @Steps
    LoginForm form;


    @Step
    public void openLoginPage() {
        getDriver().get("https://todoist.com/auth/login");
    }

    @Step
    public void waitForGlassToClose() {
        find(LOADING_GLASS).waitUntilNotVisible();
        find(TOP_BAR).waitUntilVisible();
    }

    public void storeCookie() {
        CookieMonster.addCookie(getDriver().manage().getCookieNamed("todoistd"));
        CookieMonster.addCookie(getDriver().manage().getCookieNamed("tduser"));
        CookieMonster.addCookie(getDriver().manage().getCookieNamed("csrf"));
    }

    public void openMainPage() {
        if (userIsLoggedIn()) {
            gotoToMainPage();
        } else {
            processUserLogin();
        }
    }

    private boolean userIsLoggedIn() {
        return CookieMonster.getCookies().size() > 0;
    }

    private void gotoToMainPage() {
        getDriver().get("https://todoist.com/static/errors/404.jpg");
        for (var c : CookieMonster.getCookies()) {
            getDriver().manage().addCookie(c);
        }
        getDriver().get("https://todoist.com/app/today");
    }

    private void processUserLogin() {
        openLoginPage();
        form.fullFormFill("gbinxeqerpnywwysux@awdrt.org", "ti4FCvBL39i7mMq");
        waitForGlassToClose();
        storeCookie();
    }
}
