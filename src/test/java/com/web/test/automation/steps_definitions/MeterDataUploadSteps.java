package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.MeterDataUploadScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MeterDataUploadSteps {

    private final MeterDataUploadScreen meterDataUploadScreen = new MeterDataUploadScreen();

    @Given("user is on the Meter Data Upload module page")
    public void user_is_on_the_meter_data_upload_module_page() {
        meterDataUploadScreen.openMeterDataUploadModule();
    }

    @When("user views the Meter Data Upload module")
    public void user_views_the_meter_data_upload_module() {
        // Navigation handled in background
    }

    @Then("Meter Data Upload grid should be visible")
    public void meter_data_upload_grid_should_be_visible() {
        meterDataUploadScreen.verifyMeterDataUploadPageIsVisible();
    }
}

