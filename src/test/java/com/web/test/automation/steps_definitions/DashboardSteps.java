package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.DashboardScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps {

    private final DashboardScreen dashboardScreen = new DashboardScreen();

    @Given("user is on the Dashboard module page")
    public void user_is_on_the_dashboard_module_page() {
        dashboardScreen.openDashboardModule();
    }

    @When("user views the Dashboard module")
    public void user_views_the_dashboard_module() {
        // Navigation is already handled in the background; keep for readability and future steps
    }

    @Then("Dashboard widgets and summary information should be visible")
    public void dashboard_widgets_and_summary_information_should_be_visible() {
        dashboardScreen.verifyDashboardIsVisible();
    }
}

