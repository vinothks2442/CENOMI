package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class ConfigurationScreen {

    private final PlayActions play = new PlayActions();

    private final String configurationMenuItem = "//a[normalize-space()='Configuration']";
    private final String configurationHeading = "//h1[normalize-space()='Configuration']";

    public void openConfigurationModule() {
        play.click(configurationMenuItem, "Configuration menu item");
    }

    public void verifyConfigurationPageIsVisible() {
        String actualHeading = play.textContent(configurationHeading);
        Assert.assertEquals("Configuration", actualHeading);
    }
}

