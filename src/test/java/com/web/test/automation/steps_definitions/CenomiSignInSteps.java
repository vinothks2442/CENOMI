package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.CenomiSignInScreen;

import io.cucumber.java.en.*;

public class CenomiSignInSteps {
	
	CenomiSignInScreen signIn = new CenomiSignInScreen();
	
	 @Given("user is in the cenomi landing page")
    public void user_is_in_the_cenomi_landing_page() {
       signIn.cenomiLandingPage();    }

    @When("user clicks sign in button")
    public void user_clicks_sign_in_button() {
       
    }

    @And("user enters the registered email and clicks on the continue button")
    public void user_enters_the_registered_email_and_clicks_on_the_continue_button() {
        
    }

    @Then("user should able to see the dashboard page if user is already registered with cenomi platform")
    public void user_should_able_to_see_the_dashboard_page_if_user_is_already_registered_with_cenomi_platform() {
       
    }

}
