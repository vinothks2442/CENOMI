package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.LeaseRequestScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeaseRequestSteps {

    private final LeaseRequestScreen leaseRequestScreen = new LeaseRequestScreen();

    @Given("user is on the Lease Request module page")
    public void user_is_on_the_lease_request_module_page() {
        leaseRequestScreen.openLeaseRequestModule();
    }

    @When("user views the Lease Request module")
    public void user_views_the_lease_request_module() {
        // Navigation handled in background
    }

    @Then("Lease Request list should be visible")
    public void lease_request_list_should_be_visible() {
        leaseRequestScreen.verifyLeaseRequestPageIsVisible();
    }
}

