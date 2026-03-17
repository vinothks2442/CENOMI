package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class BrandsScreen {

    private final PlayActions play = new PlayActions();

    private final String brandsMenuItem = "//a[normalize-space()='Brands']";
    private final String brandsHeading = "//h1[normalize-space()='Brands']";

    public void openBrandsModule() {
        play.click(brandsMenuItem, "Brands menu item");
    }

    public void verifyBrandsPageIsVisible() {
        String actualHeading = play.textContent(brandsHeading);
        Assert.assertEquals("Brands", actualHeading);
    }
}

