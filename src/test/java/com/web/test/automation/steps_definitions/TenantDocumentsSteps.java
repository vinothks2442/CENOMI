package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.TenantDocumentsScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TenantDocumentsSteps {

    private final TenantDocumentsScreen tenantDocumentsScreen = new TenantDocumentsScreen();

    @Given("user is on the Tenant Documents module page")
    public void user_is_on_the_tenant_documents_module_page() {
        tenantDocumentsScreen.openTenantDocumentsModule();
    }

    @When("user views the Tenant Documents module")
    public void user_views_the_tenant_documents_module() {
        // Navigation handled in background
    }

    @Then("Tenant Documents list should be visible")
    public void tenant_documents_list_should_be_visible() {
        tenantDocumentsScreen.verifyTenantDocumentsPageIsVisible();
    }
}

