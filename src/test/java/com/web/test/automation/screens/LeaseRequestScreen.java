package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class LeaseRequestScreen {

    private final PlayActions play = new PlayActions();

    private final String leaseRequestMenuItem = "//a[normalize-space()='Lease Request']";
    private final String leaseRequestHeading = "//h1[normalize-space()='Lease Request']";

    public void openLeaseRequestModule() {
        play.click(leaseRequestMenuItem, "Lease Request menu item");
    }

    public void verifyLeaseRequestPageIsVisible() {
        String actualHeading = play.textContent(leaseRequestHeading);
        Assert.assertEquals("Lease Request", actualHeading);
    }
}

