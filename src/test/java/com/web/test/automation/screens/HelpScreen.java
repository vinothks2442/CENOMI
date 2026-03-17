package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class HelpScreen {

    private final PlayActions play = new PlayActions();

    private final String helpMenuItem = "//a[normalize-space()='Help']";
    private final String helpHeading = "//h1[normalize-space()='Help']";

    public void openHelpModule() {
        play.click(helpMenuItem, "Help menu item");
    }

    public void verifyHelpPageIsVisible() {
        String actualHeading = play.textContent(helpHeading);
        Assert.assertEquals("Help", actualHeading);
    }
}

