package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.HelpScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HelpSteps {

    private final HelpScreen helpScreen = new HelpScreen();

    @Given("user is on the Help module page")
    public void user_is_on_the_help_module_page() {
        helpScreen.openHelpModule();
    }

    @When("user views the Help module")
    public void user_views_the_help_module() {
        // Navigation handled in background
    }

    @Then("Help content should be visible")
    public void help_content_should_be_visible() {
        helpScreen.verifyHelpPageIsVisible();
    }
}

