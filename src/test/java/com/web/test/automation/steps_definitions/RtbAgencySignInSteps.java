package com.web.test.automation.steps_definitions;

import com.web.test.automation.screens.RtbAgencySignInScreen;

import io.cucumber.java.en.*;

public class RtbAgencySignInSteps {
	
	RtbAgencySignInScreen page = new RtbAgencySignInScreen();
	
	@Given("user is in the rtb landing page")
	public void user_is_in_the_rtb_landing_page() {
	    page.rtbLandingPage();
	}

	@When("user clicks in get started button")
	public void user_clicks_in_get_started_button() {
	    page.clicksOnGetStartedBtn();
	}
	
	@Then("user should able to see who you are page")
	public void user_should_able_to_see_who_you_are_page() throws InterruptedException {
	    page.whoYouArePage();
	}

	@When("user chooses the agency admin role and clicks on continue button")
	public void user_chooses_the_agency_admin_role_and_clicks_on_continue_button() {
	    page.chooseAgencyAdmClicksConBtn();
	}

	@Then("user should able to see enter your email page")
	public void user_should_able_to_see_enter_your_email_page() {
	    page.enterEmailPage();
	}

	@When("user enters the email and clicks on the continue button")
	public void user_enters_the_email_and_clicks_on_the_continue_button() {
	    page.entersEmailClicksOnConButn();
	}

	@Then("user should able to see otp page")
	public void user_should_able_to_see_otp_page() {
	    page.otpPage();
	}

	@When("user enters the otp and clicks on the verity otp button")
	public void user_enters_the_otp_and_clicks_on_the_verity_otp_button() throws InterruptedException {
	    page.entersOtpClicksOnVfyOtpBtn();
	}

	@Then("user should able to see the dashboard page if user is already registered")
	public void user_should_able_to_see_the_dashboard_page_if_user_is_already_registered() throws InterruptedException {
	    page.dashboardPage();
	}

}
