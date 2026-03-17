package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.UsersTenantUserScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersTenantUserSteps {

    private final UsersTenantUserScreen tenantUserScreen = new UsersTenantUserScreen();

    @Given("user is on the Tenant User page under Users module")
    public void user_is_on_the_tenant_user_page_under_users_module() {
        tenantUserScreen.openTenantUserSubmodule();
    }

    @When("user views the Tenant User list")
    public void user_views_the_tenant_user_list() {
        // Navigation is already done in the background; extra steps can be added later
    }

    @Then("Tenant User records should be visible")
    public void tenant_user_records_should_be_visible() {
        tenantUserScreen.verifyTenantUserListVisible();
    }
}

