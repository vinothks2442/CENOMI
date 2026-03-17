package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.FitOutAndHandoverScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FitOutAndHandoverSteps {

    private final FitOutAndHandoverScreen fitOutAndHandoverScreen = new FitOutAndHandoverScreen();

    @Given("user is on the Fit-out & Handover module page")
    public void user_is_on_the_fit_out_and_handover_module_page() {
        fitOutAndHandoverScreen.openFitOutAndHandoverModule();
    }

    @When("user views the Fit-out & Handover module")
    public void user_views_the_fit_out_and_handover_module() {
        // Navigation handled in background
    }

    @Then("Fit-out & Handover items should be visible")
    public void fit_out_and_handover_items_should_be_visible() {
        fitOutAndHandoverScreen.verifyFitOutAndHandoverPageIsVisible();
    }
}

