package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.ConfigurationScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConfigurationSteps {

    private final ConfigurationScreen configurationScreen = new ConfigurationScreen();

    @Given("user is on the Configuration module page")
    public void user_is_on_the_configuration_module_page() {
        configurationScreen.openConfigurationModule();
    }

    @When("user views the Configuration module")
    public void user_views_the_configuration_module() {
        // Navigation handled in background
    }

    @Then("Configuration settings should be visible")
    public void configuration_settings_should_be_visible() {
        configurationScreen.verifyConfigurationPageIsVisible();
    }
}

