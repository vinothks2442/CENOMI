package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class MeterDataUploadScreen {

    private final PlayActions play = new PlayActions();

    private final String meterDataUploadMenuItem = "//a[normalize-space()='Meter Data Upload']";
    private final String meterDataUploadHeading = "//h1[normalize-space()='Meter Data Upload']";

    public void openMeterDataUploadModule() {
        play.click(meterDataUploadMenuItem, "Meter Data Upload menu item");
    }

    public void verifyMeterDataUploadPageIsVisible() {
        String actualHeading = play.textContent(meterDataUploadHeading);
        Assert.assertEquals("Meter Data Upload", actualHeading);
    }
}

