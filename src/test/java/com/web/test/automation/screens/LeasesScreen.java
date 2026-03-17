package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class LeasesScreen {

    private final PlayActions play = new PlayActions();

    private final String leasesMenuItem = "//a[normalize-space()='Leases']";
    private final String leasesHeading = "//h1[normalize-space()='Leases']";

    public void openLeasesModule() {
        play.click(leasesMenuItem, "Leases menu item");
    }

    public void verifyLeasesPageIsVisible() {
        String actualHeading = play.textContent(leasesHeading);
        Assert.assertEquals("Leases", actualHeading);
    }
}

