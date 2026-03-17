package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class TenantDocumentsScreen {

    private final PlayActions play = new PlayActions();

    private final String tenantDocumentsMenuItem = "//a[normalize-space()='Tenant Documents']";
    private final String tenantDocumentsHeading = "//h1[normalize-space()='Tenant Documents']";

    public void openTenantDocumentsModule() {
        play.click(tenantDocumentsMenuItem, "Tenant Documents menu item");
    }

    public void verifyTenantDocumentsPageIsVisible() {
        String actualHeading = play.textContent(tenantDocumentsHeading);
        Assert.assertEquals("Tenant Documents", actualHeading);
    }
}

