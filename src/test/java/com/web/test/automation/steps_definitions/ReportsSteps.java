package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.ReportsScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportsSteps {

    private final ReportsScreen reportsScreen = new ReportsScreen();

    @Given("user is on the Reports module page")
    public void user_is_on_the_reports_module_page() {
        reportsScreen.openReportsModule();
    }

    @When("user views the Reports module")
    public void user_views_the_reports_module() {
        // Navigation handled in background
    }

    @Then("Reports list should be visible")
    public void reports_list_should_be_visible() {
        reportsScreen.verifyReportsPageIsVisible();
    }
}

