package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class AuditLogScreen {

    private final PlayActions play = new PlayActions();

    private final String auditLogMenuItem = "//a[normalize-space()='Audit Log']";
    private final String auditLogHeading = "//h1[normalize-space()='Audit Log']";

    public void openAuditLogModule() {
        play.click(auditLogMenuItem, "Audit Log menu item");
    }

    public void verifyAuditLogPageIsVisible() {
        String actualHeading = play.textContent(auditLogHeading);
        Assert.assertEquals("Audit Log", actualHeading);
    }
}

