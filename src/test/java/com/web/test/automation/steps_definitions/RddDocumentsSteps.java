package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.RddDocumentsScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RddDocumentsSteps {

    private final RddDocumentsScreen rddDocumentsScreen = new RddDocumentsScreen();

    @Given("user is on the RDD Documents module page")
    public void user_is_on_the_rdd_documents_module_page() {
        rddDocumentsScreen.openRddDocumentsModule();
    }

    @When("user views the RDD Documents module")
    public void user_views_the_rdd_documents_module() {
        // Navigation handled in background
    }

    @Then("RDD Documents list should be visible")
    public void rdd_documents_list_should_be_visible() {
        rddDocumentsScreen.verifyRddDocumentsPageIsVisible();
    }
}

