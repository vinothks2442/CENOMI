package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.MailAnnouncementScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MailAnnouncementSteps {

    private final MailAnnouncementScreen mailAnnouncementScreen = new MailAnnouncementScreen();

    @Given("user is on the Mail Announcement module page")
    public void user_is_on_the_mail_announcement_module_page() {
        mailAnnouncementScreen.openMailAnnouncementModule();
    }

    @When("user views the Mail Announcement module")
    public void user_views_the_mail_announcement_module() {
        // Navigation handled in background
    }

    @Then("Mail Announcement list should be visible")
    public void mail_announcement_list_should_be_visible() {
        mailAnnouncementScreen.verifyMailAnnouncementPageIsVisible();
    }
}

