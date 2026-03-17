package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class LeaseDocumentScreen {

    private final PlayActions play = new PlayActions();

    private final String leaseDocumentMenuItem = "//a[normalize-space()='Lease Document']";
    private final String leaseDocumentHeading = "//h1[normalize-space()='Lease Document']";

    public void openLeaseDocumentModule() {
        play.click(leaseDocumentMenuItem, "Lease Document menu item");
    }

    public void verifyLeaseDocumentPageIsVisible() {
        String actualHeading = play.textContent(leaseDocumentHeading);
        Assert.assertEquals("Lease Document", actualHeading);
    }
}

