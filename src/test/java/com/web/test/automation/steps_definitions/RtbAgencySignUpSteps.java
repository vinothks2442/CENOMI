package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.RtbAgencySignUpScreen;

import io.cucumber.java.en.*;

public class RtbAgencySignUpSteps {
	
	RtbAgencySignUpScreen page = new RtbAgencySignUpScreen();
	
	@When("user enters the new user email and clicks on the continue button")
	public void user_enters_the_new_user_email_and_clicks_on_the_continue_button() {
	    page.entersNewEmailClickConBtn();
	}
	
	@Then("user should able to see the onboarding form")
	public void user_should_able_to_see_the_onboarding_form() throws InterruptedException {
	    page.agencyOnboardingPage();
	}
	
	@When("user fills the onboarding details")
	public void user_fills_the_onboarding_details() throws InterruptedException {
	    page.fillsOnboardDetails();
	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() {
	    page.clicksConBtn();
	}

	@Then("user should able to see hey its great to see you page")
	public void user_should_able_to_see_hey_its_great_to_see_you_page() {
	    page.heyItsGreatToSeePage();
	}

	@When("user clicks on back button")
	public void user_clicks_on_back_button() {
	    page.clicksBackBtn();
	}

	@Then("user should able to see details still visible")
	public void user_should_able_to_see_details_still_visible() throws Throwable {
	    page.seeDetailsStillVisible();
	}

	
	@Then("user clicks on another continue button")
	public void user_clicks_on_another_continue_button() {
	    page.clicksOnAnotherConBtn();
	}

	@Then("user should able to see property management software choosing page")
	public void user_should_able_to_see_property_management_software_choosing_page() {
	    page.pmsChooseingPage();
	}

	@When("user choose the property me software and clicks on the continue button")
	public void user_choose_the_property_me_software_and_clicks_on_the_continue_button() {
	    page.choosePmsToolAndClickOnConBtn();
	}

	@Then("user should able to see the property me log in page")
	public void user_should_able_to_see_the_property_me_log_in_page() {
	    page.propMeLogInPage();
	}


}
