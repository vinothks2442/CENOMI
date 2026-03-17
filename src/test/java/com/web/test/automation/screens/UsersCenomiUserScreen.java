package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class UsersCenomiUserScreen {

    private final PlayActions play = new PlayActions();

    private final String usersMenuItem = "//a[normalize-space()='Users']";
    private final String cenomiUserTab = "//a[normalize-space()='Cenomi User']";
    private final String cenomiUserTable = "//table[contains(@class,'cenomi-user-table')]";

    public void openCenomiUserSubmodule() {
        play.click(usersMenuItem, "Users menu item");
        play.click(cenomiUserTab, "Cenomi User tab");
    }

    public void verifyCenomiUserListVisible() {
        String tableHtml = play.innerHTML(cenomiUserTable);
        Assert.assertNotNull(tableHtml);
    }
}

