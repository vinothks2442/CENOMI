package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.LeasesScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeasesSteps {

    private final LeasesScreen leasesScreen = new LeasesScreen();

    @Given("user is on the Leases module page")
    public void user_is_on_the_leases_module_page() {
        leasesScreen.openLeasesModule();
    }

    @When("user views the Leases module")
    public void user_views_the_leases_module() {
        // Navigation handled in background
    }

    @Then("Leases list should be visible")
    public void leases_list_should_be_visible() {
        leasesScreen.verifyLeasesPageIsVisible();
    }
}

