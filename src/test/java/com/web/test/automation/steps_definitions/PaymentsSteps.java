package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.PaymentsScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentsSteps {

    private final PaymentsScreen paymentsScreen = new PaymentsScreen();

    @Given("user is on the Payments module page")
    public void user_is_on_the_payments_module_page() {
        paymentsScreen.openPaymentsModule();
    }

    @When("user views the Payments module")
    public void user_views_the_payments_module() {
        // Navigation handled in background
    }

    @Then("Payments list should be visible")
    public void payments_list_should_be_visible() {
        paymentsScreen.verifyPaymentsPageIsVisible();
    }
}

