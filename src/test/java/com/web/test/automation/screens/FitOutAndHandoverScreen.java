package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class FitOutAndHandoverScreen {

    private final PlayActions play = new PlayActions();

    private final String fitOutAndHandoverMenuItem = "//a[normalize-space()='Fit-out & Handover']";
    private final String fitOutAndHandoverHeading = "//h1[normalize-space()='Fit-out & Handover']";

    public void openFitOutAndHandoverModule() {
        play.click(fitOutAndHandoverMenuItem, "Fit-out & Handover menu item");
    }

    public void verifyFitOutAndHandoverPageIsVisible() {
        String actualHeading = play.textContent(fitOutAndHandoverHeading);
        Assert.assertEquals("Fit-out & Handover", actualHeading);
    }
}

