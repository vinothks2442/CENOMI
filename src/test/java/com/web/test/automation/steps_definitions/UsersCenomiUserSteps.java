package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.UsersCenomiUserScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersCenomiUserSteps {

    private final UsersCenomiUserScreen cenomiUserScreen = new UsersCenomiUserScreen();

    @Given("user is on the Cenomi User page under Users module")
    public void user_is_on_the_cenomi_user_page_under_users_module() {
        cenomiUserScreen.openCenomiUserSubmodule();
    }

    @When("user views the Cenomi User list")
    public void user_views_the_cenomi_user_list() {
        // Navigation is already done in the background; extra steps can be added later
    }

    @Then("Cenomi User records should be visible")
    public void cenomi_user_records_should_be_visible() {
        cenomiUserScreen.verifyCenomiUserListVisible();
    }
}

