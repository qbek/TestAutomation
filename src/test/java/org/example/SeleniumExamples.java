package org.example;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import org.example.steps.SeleniumSteps;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExamples extends Base {

    @Steps
    SeleniumSteps steps;

    @Managed
    WebDriver driver;

    @Test
    public void userCanLogin() {
        steps.userOpensLoginPage();
        steps.userEntersValidCredentials();
        steps.userIsLoggedIn();
    }

    @Test
    public void userIsLoggedIn() {
        steps.userOpensMainPage();
    }
}
