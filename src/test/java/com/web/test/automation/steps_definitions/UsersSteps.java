package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.UsersScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersSteps {

    private final UsersScreen usersScreen = new UsersScreen();

    @Given("user is on the Users module page")
    public void user_is_on_the_users_module_page() {
        usersScreen.openUsersModule();
    }

    @When("user views the Users module")
    public void user_views_the_users_module() {
        // Navigation is already handled in the background; keep for readability and future steps
    }

    @Then("Users summary information should be visible")
    public void users_summary_information_should_be_visible() {
        usersScreen.verifyUsersPageIsVisible();
    }
}

