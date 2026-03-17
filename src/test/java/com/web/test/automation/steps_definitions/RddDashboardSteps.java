package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.RddDashboardScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RddDashboardSteps {

    private final RddDashboardScreen rddDashboardScreen = new RddDashboardScreen();

    @Given("user is on the RDD Dashboard module page")
    public void user_is_on_the_rdd_dashboard_module_page() {
        rddDashboardScreen.openRddDashboardModule();
    }

    @When("user views the RDD Dashboard module")
    public void user_views_the_rdd_dashboard_module() {
        // Navigation handled in background; extend later as needed
    }

    @Then("RDD Dashboard widgets and summary information should be visible")
    public void rdd_dashboard_widgets_and_summary_information_should_be_visible() {
        rddDashboardScreen.verifyRddDashboardPageIsVisible();
    }
}

