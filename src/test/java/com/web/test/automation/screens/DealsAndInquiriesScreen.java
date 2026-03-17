package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class DealsAndInquiriesScreen {

    private final PlayActions play = new PlayActions();

    private final String dealsAndInquiriesMenuItem = "//a[normalize-space()='Deals and Inquiries']";
    private final String dealsAndInquiriesHeading = "//h1[normalize-space()='Deals and Inquiries']";

    public void openDealsAndInquiriesModule() {
        play.click(dealsAndInquiriesMenuItem, "Deals and Inquiries menu item");
    }

    public void verifyDealsAndInquiriesPageIsVisible() {
        String actualHeading = play.textContent(dealsAndInquiriesHeading);
        Assert.assertEquals("Deals and Inquiries", actualHeading);
    }
}

