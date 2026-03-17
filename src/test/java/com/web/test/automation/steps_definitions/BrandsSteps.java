package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.BrandsScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrandsSteps {

    private final BrandsScreen brandsScreen = new BrandsScreen();

    @Given("user is on the Brands module page")
    public void user_is_on_the_brands_module_page() {
        brandsScreen.openBrandsModule();
    }

    @When("user views the Brands module")
    public void user_views_the_brands_module() {
        // Navigation handled in background
    }

    @Then("Brands list should be visible")
    public void brands_list_should_be_visible() {
        brandsScreen.verifyBrandsPageIsVisible();
    }
}

