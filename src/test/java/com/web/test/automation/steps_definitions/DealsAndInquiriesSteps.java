package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.DealsAndInquiriesScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DealsAndInquiriesSteps {

    private final DealsAndInquiriesScreen dealsAndInquiriesScreen = new DealsAndInquiriesScreen();

    @Given("user is on the Deals and Inquiries module page")
    public void user_is_on_the_deals_and_inquiries_module_page() {
        dealsAndInquiriesScreen.openDealsAndInquiriesModule();
    }

    @When("user views the Deals and Inquiries module")
    public void user_views_the_deals_and_inquiries_module() {
        // Navigation handled in background
    }

    @Then("Deals and Inquiries list should be visible")
    public void deals_and_inquiries_list_should_be_visible() {
        dealsAndInquiriesScreen.verifyDealsAndInquiriesPageIsVisible();
    }
}

