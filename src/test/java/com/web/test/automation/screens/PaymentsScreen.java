package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class PaymentsScreen {

    private final PlayActions play = new PlayActions();

    private final String paymentsMenuItem = "//a[normalize-space()='Payments']";
    private final String paymentsHeading = "//h1[normalize-space()='Payments']";

    public void openPaymentsModule() {
        play.click(paymentsMenuItem, "Payments menu item");
    }

    public void verifyPaymentsPageIsVisible() {
        String actualHeading = play.textContent(paymentsHeading);
        Assert.assertEquals("Payments", actualHeading);
    }
}

