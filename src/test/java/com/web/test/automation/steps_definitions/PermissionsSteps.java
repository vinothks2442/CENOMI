package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.PermissionsScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PermissionsSteps {

    private final PermissionsScreen permissionsScreen = new PermissionsScreen();

    @Given("user is on the Permissions module page")
    public void user_is_on_the_permissions_module_page() {
        permissionsScreen.openPermissionsModule();
    }

    @When("user views the Permissions module")
    public void user_views_the_permissions_module() {
        // Navigation handled in background
    }

    @Then("Permissions settings should be visible")
    public void permissions_settings_should_be_visible() {
        permissionsScreen.verifyPermissionsPageIsVisible();
    }
}

