package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.NewInquiryScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewInquirySteps {

    private final NewInquiryScreen newInquiryScreen = new NewInquiryScreen();

    @Given("user is on the New Inquiry module page")
    public void user_is_on_the_new_inquiry_module_page() {
        newInquiryScreen.openNewInquiryModule();
    }

    @When("user views the New Inquiry module")
    public void user_views_the_new_inquiry_module() {
        // Navigation handled in background
    }

    @Then("New Inquiry form should be visible")
    public void new_inquiry_form_should_be_visible() {
        newInquiryScreen.verifyNewInquiryPageIsVisible();
    }
}

