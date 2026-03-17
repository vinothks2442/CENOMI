package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.TenantProfileScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TenantProfileSteps {

    private final TenantProfileScreen tenantProfileScreen = new TenantProfileScreen();

    @Given("user is on the Tenant Profile module page")
    public void user_is_on_the_tenant_profile_module_page() {
        tenantProfileScreen.openTenantProfileModule();
    }

    @When("user views the Tenant Profile module")
    public void user_views_the_tenant_profile_module() {
        // Navigation handled in background
    }

    @Then("Tenant Profile details should be visible")
    public void tenant_profile_details_should_be_visible() {
        tenantProfileScreen.verifyTenantProfilePageIsVisible();
    }
}

