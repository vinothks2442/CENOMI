package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class RddDashboardScreen {

    private final PlayActions play = new PlayActions();

    private final String rddDashboardMenuItem = "//a[normalize-space()='RDD Dashboard']";
    private final String rddDashboardHeading = "//h1[normalize-space()='RDD Dashboard']";

    public void openRddDashboardModule() {
        play.click(rddDashboardMenuItem, "RDD Dashboard menu item");
    }

    public void verifyRddDashboardPageIsVisible() {
        String actualHeading = play.textContent(rddDashboardHeading);
        Assert.assertEquals("RDD Dashboard", actualHeading);
    }
}

