package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.LeaseDocumentScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeaseDocumentSteps {

    private final LeaseDocumentScreen leaseDocumentScreen = new LeaseDocumentScreen();

    @Given("user is on the Lease Document module page")
    public void user_is_on_the_lease_document_module_page() {
        leaseDocumentScreen.openLeaseDocumentModule();
    }

    @When("user views the Lease Document module")
    public void user_views_the_lease_document_module() {
        // Navigation handled in background
    }

    @Then("Lease Document list should be visible")
    public void lease_document_list_should_be_visible() {
        leaseDocumentScreen.verifyLeaseDocumentPageIsVisible();
    }
}

