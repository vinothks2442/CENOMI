package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class ReportsScreen {

    private final PlayActions play = new PlayActions();

    private final String reportsMenuItem = "//a[normalize-space()='Reports']";
    private final String reportsHeading = "//h1[normalize-space()='Reports']";

    public void openReportsModule() {
        play.click(reportsMenuItem, "Reports menu item");
    }

    public void verifyReportsPageIsVisible() {
        String actualHeading = play.textContent(reportsHeading);
        Assert.assertEquals("Reports", actualHeading);
    }
}

