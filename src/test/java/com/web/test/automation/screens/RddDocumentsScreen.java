package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class RddDocumentsScreen {

    private final PlayActions play = new PlayActions();

    private final String rddDocumentsMenuItem = "//a[normalize-space()='RDD Documents']";
    private final String rddDocumentsHeading = "//h1[normalize-space()='RDD Documents']";

    public void openRddDocumentsModule() {
        play.click(rddDocumentsMenuItem, "RDD Documents menu item");
    }

    public void verifyRddDocumentsPageIsVisible() {
        String actualHeading = play.textContent(rddDocumentsHeading);
        Assert.assertEquals("RDD Documents", actualHeading);
    }
}

