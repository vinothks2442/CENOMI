package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import com.automation.web.common_utils.ConfigReader;

import junit.framework.Assert;

public class CenomiSignInScreen {
	
	PlayActions play = new PlayActions();
	
	String getStarted = "//button[text()='Get Started']";
	String emailPage = "//p[text()='Enter Your Email']";
	String emailInpt = "//input[@name='email']";
	String conBtn = "#email-submit-btn";
	String otpPage = "//p[text()='Verify OTP']";
	String otpInpt = "//input[@name='otp']";
	String verifyBtn = "#otp-form-verify-btn";
	String dashboardHeading = "//h1[text()='Dashboard']";
	String whoYouArePage = "//p[text()='Please tell us who you are']";
	String agencyAdm = "//h3[text()='Agency Admin']";
	String conBtn1 = "//button[text()='Continue']";

	public void cenomiLandingPage() {
		play.navigate(ConfigReader.getValue("uatUrl"));
	}

	public void clicksOnGetStartedBtn() {
		play.click(getStarted, "Get Started");
	}
	
	public void whoYouArePage() throws InterruptedException {
		Thread.sleep(1000);
		String actaulTxt = play.textContent(whoYouArePage);
		Assert.assertEquals(actaulTxt, "Please tell us who you are");
	}

	public void chooseAgencyAdmClicksConBtn() {
		play.click(agencyAdm, "agency Admin");
		play.click(conBtn1, "Continue Button");
	}

	public void enterEmailPage() {
		String actaulTxt = play.textContent(emailPage);
		Assert.assertEquals(actaulTxt, "Enter Your Email");
	}

	public void entersEmailClicksOnConButn() {
		play.fill(emailInpt, ConfigReader.getValue("adminEmail"), "Email");
		play.click(conBtn, "Continue Button");
	}

	public void otpPage() {
		String actaulTxt = play.textContent(otpPage);
		Assert.assertEquals(actaulTxt, "Verify OTP");
	}

	public void entersOtpClicksOnVfyOtpBtn() throws InterruptedException {
		
		play.fill(otpInpt, ConfigReader.getValue("otpText"), "OTP");
		play.click(verifyBtn, "Verify otp Button");
	}

	public void dashboardPage() throws InterruptedException {
		Thread.sleep(5000);
		String actaulTxt = play.textContent(dashboardHeading);
		Assert.assertEquals(actaulTxt, "Dashboard");
	}

	
	
	

}
