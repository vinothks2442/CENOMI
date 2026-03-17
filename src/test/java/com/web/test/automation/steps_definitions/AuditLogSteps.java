package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.AuditLogScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuditLogSteps {

    private final AuditLogScreen auditLogScreen = new AuditLogScreen();

    @Given("user is on the Audit Log module page")
    public void user_is_on_the_audit_log_module_page() {
        auditLogScreen.openAuditLogModule();
    }

    @When("user views the Audit Log module")
    public void user_views_the_audit_log_module() {
        // Navigation handled in background
    }

    @Then("Audit Log entries should be visible")
    public void audit_log_entries_should_be_visible() {
        auditLogScreen.verifyAuditLogPageIsVisible();
    }
}

