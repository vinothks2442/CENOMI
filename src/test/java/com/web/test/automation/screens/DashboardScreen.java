package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class DashboardScreen {

    private final PlayActions play = new PlayActions();

    // Left menu and page locators (adjust as needed)
    private final String dashboardMenuItem = "//a[normalize-space()='Dashboard']";
    private final String dashboardHeading = "//h1[normalize-space()='Dashboard']";

    public void openDashboardModule() {
        play.click(dashboardMenuItem, "Dashboard menu item");
    }

    public void verifyDashboardIsVisible() {
        String actualHeading = play.textContent(dashboardHeading);
        Assert.assertEquals("Dashboard", actualHeading);
    }
}

