package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.SalesDataScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesDataSteps {

    private final SalesDataScreen salesDataScreen = new SalesDataScreen();

    @Given("user is on the Sales Data module page")
    public void user_is_on_the_sales_data_module_page() {
        salesDataScreen.openSalesDataModule();
    }

    @When("user views the Sales Data module")
    public void user_views_the_sales_data_module() {
        // Navigation handled in background
    }

    @Then("Sales Data summary should be visible")
    public void sales_data_summary_should_be_visible() {
        salesDataScreen.verifySalesDataPageIsVisible();
    }
}

