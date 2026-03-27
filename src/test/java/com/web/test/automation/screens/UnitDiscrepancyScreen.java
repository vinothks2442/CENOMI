package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;

public class UnitDiscrepancyScreen {

    PlayActions play = new PlayActions();

    // Locators
    String dashboardMenu = "//p[text()='Dashboard']";
    String widget = "//div[text()='Unit Discrepancy Report']";
    String graph = "(//*[contains(text(),'Unit Discrepancy')]//following::div[contains(@class,'recharts-wrapper')][1])[2]";
    String yearDropdown = "(//div[text()='Unit Discrepancy Report']/following::select)[1]";
    String monthDropdown = "(//div[text()='Unit Discrepancy Report']/following::select)[2]";
    String viewAllBtn = "//button[text()='View All']";
    String reportPage = "//h1[text()='Unit Discrepancy Report']";
    String mallList = "//div[@class='mall-list']";
    String table = "//table";
    String noDataMsg = "//p[text()='No Data Available']";

    public void navigateToDashboard() {
        play.waitForVisible(dashboardMenu, 5000, "Dashboard");
    }

    public void scrollToWidget() {
        play.scrollToElement(widget, "Unit Discrepancy Widget");
    }

    public void verifyGraphVisible() throws InterruptedException {
        Thread.sleep(2000);
        play.isVisible(graph, "Graph");
    }

    public void verifyFilters() throws InterruptedException {
        Thread.sleep(2000);
        play.isVisible(yearDropdown, "Year Dropdown");
        play.isVisible(monthDropdown, "Month Dropdown");
    }

    public void selectYear(String year) {
        play.selectOptionsByValue(yearDropdown, year);
    }

    public void selectMonth(String month) {
        play.selectOptionsByValue(monthDropdown, month);
    }

    public void verifyGraphUpdated() {
        play.waitForSelector(graph, 5000, "Graph Updated");
    }

    public void verifyMallData() {
        play.isVisible(graph, "Mall Data Graph");
    }

    public void clickViewAll() {
        play.click(viewAllBtn, "View All Button");
    }

    public void verifyReportPage() {
        play.waitForVisible(reportPage, 5000, "Report Page");
    }

    public void verifyMallList() {
        play.isVisible(mallList, "Mall List");
    }

    public void verifyTableStructure() {
        play.isVisible(table, "Table");
    }

    public void verifyGraphVsTable() {
        // Basic validation (can be enhanced with API later)
        play.isVisible(graph, "Graph");
        play.isVisible(table, "Table");
    }

    public void selectNoDataMonth() {
        play.selectOptionFromDropdown(monthDropdown, "January");
    }

    public void verifyNoData() {
        play.isVisible(noDataMsg, "No Data Message");
    }
}