package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.UnitDiscrepancyScreen;
import io.cucumber.java.en.*;

public class UnitDiscrepancySteps {

    UnitDiscrepancyScreen unitDiscrepancyScreen = new UnitDiscrepancyScreen();

    @Given("user is logged into Cenomi and on dashboard page")
    public void user_on_dashboard() {
        unitDiscrepancyScreen.navigateToDashboard();
    }

    @When("user navigates to Unit Discrepancy widget")
    public void navigate_widget() {
        unitDiscrepancyScreen.scrollToWidget();
    }

    @And("user verifies graph is visible")
    public void verify_graph() throws InterruptedException {
        unitDiscrepancyScreen.verifyGraphVisible();
    }

    @And("user verifies year and month filters are displayed")
    public void verify_filters() throws InterruptedException {
        unitDiscrepancyScreen.verifyFilters();
    }

    @And("user selects year {string} and month {string}")
    public void select_filters(String year, String month) {
        unitDiscrepancyScreen.selectYear(year);
        unitDiscrepancyScreen.selectMonth(month);
    }

    @Then("graph should update based on selected filters")
    public void verify_graph_update() {
        unitDiscrepancyScreen.verifyGraphUpdated();
    }

    @And("graph should display discrepancy count per mall")
    public void verify_mall_data() {
        unitDiscrepancyScreen.verifyMallData();
    }

    @When("user clicks on View All button in Unit Discrepancy widget")
    public void click_view_all() {
        unitDiscrepancyScreen.clickViewAll();
    }

    @Then("user should be redirected to report page")
    public void verify_navigation() {
        unitDiscrepancyScreen.verifyReportPage();
    }

    @And("user verifies mall list is displayed on left panel")
    public void verify_mall_list() {
        unitDiscrepancyScreen.verifyMallList();
    }

    @And("user verifies month wise table structure")
    public void verify_table() {
        unitDiscrepancyScreen.verifyTableStructure();
    }

    @Then("discrepancy data should match with dashboard graph")
    public void verify_data_match() {
        unitDiscrepancyScreen.verifyGraphVsTable();
    }

    @When("user selects month with no discrepancy data")
    public void select_no_data() {
        unitDiscrepancyScreen.selectNoDataMonth();
    }

    @Then("report page should also show empty state")
    public void verify_empty() {
        unitDiscrepancyScreen.verifyNoData();
    }
}