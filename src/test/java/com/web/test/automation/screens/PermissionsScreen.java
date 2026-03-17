package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class PermissionsScreen {

    private final PlayActions play = new PlayActions();

    private final String permissionsMenuItem = "//a[normalize-space()='Permissions']";
    private final String permissionsHeading = "//h1[normalize-space()='Permissions']";

    public void openPermissionsModule() {
        play.click(permissionsMenuItem, "Permissions menu item");
    }

    public void verifyPermissionsPageIsVisible() {
        String actualHeading = play.textContent(permissionsHeading);
        Assert.assertEquals("Permissions", actualHeading);
    }
}

