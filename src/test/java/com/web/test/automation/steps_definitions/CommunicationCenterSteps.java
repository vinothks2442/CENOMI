package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.CommunicationCenterScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommunicationCenterSteps {

    private final CommunicationCenterScreen communicationCenterScreen = new CommunicationCenterScreen();

    @Given("user is on the Communication Center module page")
    public void user_is_on_the_communication_center_module_page() {
        communicationCenterScreen.openCommunicationCenterModule();
    }

    @When("user views the Communication Center module")
    public void user_views_the_communication_center_module() {
        // Navigation handled in background
    }

    @Then("Communication Center items should be visible")
    public void communication_center_items_should_be_visible() {
        communicationCenterScreen.verifyCommunicationCenterPageIsVisible();
    }
}

