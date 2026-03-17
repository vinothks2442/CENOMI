package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class NewInquiryScreen {

    private final PlayActions play = new PlayActions();

    private final String newInquiryMenuItem = "//a[normalize-space()='New Inquiry']";
    private final String newInquiryHeading = "//h1[normalize-space()='New Inquiry']";

    public void openNewInquiryModule() {
        play.click(newInquiryMenuItem, "New Inquiry menu item");
    }

    public void verifyNewInquiryPageIsVisible() {
        String actualHeading = play.textContent(newInquiryHeading);
        Assert.assertEquals("New Inquiry", actualHeading);
    }
}

