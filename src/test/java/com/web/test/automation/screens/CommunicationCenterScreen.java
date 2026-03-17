package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class CommunicationCenterScreen {

    private final PlayActions play = new PlayActions();

    private final String communicationCenterMenuItem = "//a[normalize-space()='Communication Center']";
    private final String communicationCenterHeading = "//h1[normalize-space()='Communication Center']";

    public void openCommunicationCenterModule() {
        play.click(communicationCenterMenuItem, "Communication Center menu item");
    }

    public void verifyCommunicationCenterPageIsVisible() {
        String actualHeading = play.textContent(communicationCenterHeading);
        Assert.assertEquals("Communication Center", actualHeading);
    }
}

