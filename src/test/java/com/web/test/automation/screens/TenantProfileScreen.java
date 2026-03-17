package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class TenantProfileScreen {

    private final PlayActions play = new PlayActions();

    private final String tenantProfileMenuItem = "//a[normalize-space()='Tenant Profile']";
    private final String tenantProfileHeading = "//h1[normalize-space()='Tenant Profile']";

    public void openTenantProfileModule() {
        play.click(tenantProfileMenuItem, "Tenant Profile menu item");
    }

    public void verifyTenantProfilePageIsVisible() {
        String actualHeading = play.textContent(tenantProfileHeading);
        Assert.assertEquals("Tenant Profile", actualHeading);
    }
}

