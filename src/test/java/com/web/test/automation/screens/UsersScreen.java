package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class UsersScreen {

    private final PlayActions play = new PlayActions();

    private final String usersMenuItem = "//a[normalize-space()='Users']";
    private final String usersHeading = "//h1[normalize-space()='Users']";

    public void openUsersModule() {
        play.click(usersMenuItem, "Users menu item");
    }

    public void verifyUsersPageIsVisible() {
        String actualHeading = play.textContent(usersHeading);
        Assert.assertEquals("Users", actualHeading);
    }
}

