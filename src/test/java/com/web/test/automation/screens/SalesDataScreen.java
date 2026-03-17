package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class SalesDataScreen {

    private final PlayActions play = new PlayActions();

    private final String salesDataMenuItem = "//a[normalize-space()='Sales Data']";
    private final String salesDataHeading = "//h1[normalize-space()='Sales Data']";

    public void openSalesDataModule() {
        play.click(salesDataMenuItem, "Sales Data menu item");
    }

    public void verifySalesDataPageIsVisible() {
        String actualHeading = play.textContent(salesDataHeading);
        Assert.assertEquals("Sales Data", actualHeading);
    }
}

