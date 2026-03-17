package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class UsersTenantUserScreen {

    private final PlayActions play = new PlayActions();

    private final String usersMenuItem = "//a[normalize-space()='Users']";
    private final String tenantUserTab = "//a[normalize-space()='Tenant User']";
    private final String tenantUserTable = "//table[contains(@class,'tenant-user-table')]";

    public void openTenantUserSubmodule() {
        play.click(usersMenuItem, "Users menu item");
        play.click(tenantUserTab, "Tenant User tab");
    }

    public void verifyTenantUserListVisible() {
        String tableLocatorDescription = "Tenant User table";
        // If the framework has a dedicated visibility/assertion helper, replace this with that call.
        String tableHtml = play.innerHTML(tenantUserTable);
        Assert.assertNotNull(tableHtml);
    }
}

