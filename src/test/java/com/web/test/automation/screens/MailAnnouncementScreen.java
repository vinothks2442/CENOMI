package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import junit.framework.Assert;

public class MailAnnouncementScreen {

    private final PlayActions play = new PlayActions();

    private final String mailAnnouncementMenuItem = "//a[normalize-space()='Mail Announcement']";
    private final String mailAnnouncementHeading = "//h1[normalize-space()='Mail Announcement']";

    public void openMailAnnouncementModule() {
        play.click(mailAnnouncementMenuItem, "Mail Announcement menu item");
    }

    public void verifyMailAnnouncementPageIsVisible() {
        String actualHeading = play.textContent(mailAnnouncementHeading);
        Assert.assertEquals("Mail Announcement", actualHeading);
    }
}

