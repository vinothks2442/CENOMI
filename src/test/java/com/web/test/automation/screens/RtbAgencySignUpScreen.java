package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import com.automation.web.common_utils.ConfigReader;
import com.automation.web.common_utils.RandomGenerator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;

import junit.framework.Assert;

public class RtbAgencySignUpScreen {
	
	PlayActions play = new PlayActions();
	
	String emailInpt = "//input[@name='email']";
	String conBtn = "#email-submit-btn";
	String onboardPage = "//p[text()='Onboarding']";
	String inpFullName = "//input[@name='fullName']";
	String inpAgencyName = "//input[@name='agencyName']";
	String inpContact = "//input[@name='contact']";
	String stateDrpDwn = "//button/span[text()='Select State']";
	String queenslandState = "//select/option[@value='Queensland']";
	String suburb = "//input[@name='suburb']";
	String registConBtn = "#agency-register-button";
	String heyPage = "//p[contains(text(),'Hey')]";
	String goBackBtn = "#go-back-button";
	String intEmail = "//input[@name='email']";
	String anotherConBtn = "//button[text()='CONTINUE']";
	String pmsPage = "//p[text()='Property Management Software']";
	String pmsTool = "//p[text()='PropertyMe']";
	String anotherConBtn2 = "//button[text()='Continue']";
	String pmsLog = "//h1";

	public void entersNewEmailClickConBtn() {
		String ranEmail = RandomGenerator.randomEmailAddress(5);
		play.fill(emailInpt, ranEmail, "Email");
		play.click(conBtn, "Continue Button");
	}

	public void agencyOnboardingPage() throws InterruptedException {
		Thread.sleep(2000);
		String actaulTxt = play.textContent(onboardPage);
		Assert.assertEquals(actaulTxt, "Onboarding");
		
	}

	public void fillsOnboardDetails() throws InterruptedException {
		play.fill(inpFullName, "full nameee", "name");
		play.fill(inpAgencyName, "agency", conBtn);
		play.fill(inpContact, "9087654321", "Contact number");
		play.click(stateDrpDwn, "State");
//		play.getPage().selectOption("//select", "Queensland");
//		play.click("//select[@value='Queensland']", "Venkatagiri");
		Locator dropdown = play.getPage().locator("//select");
		dropdown.selectOption(new SelectOption().setLabel("Queensland"));
		play.keyboard("Enter");
		play.click(suburb, "Venkatagiri");
		play.fill(suburb, "Venkatagiri", "subrub");
	}

	public void clicksConBtn() {
		play.click(registConBtn, "Continue");
	}

	public void heyItsGreatToSeePage() {
		String string = play.textContent(heyPage);
		System.out.println(string);
	}

	public void clicksBackBtn() {
		play.click(goBackBtn, "Back Btn");
	}

	public void seeDetailsStillVisible() throws Throwable {
		Thread.sleep(3000);
		System.out.println("fullname: " + play.getAttributeValue(inpFullName, "value"));
		System.out.println("Agency name: " + play.getAttributeValue(inpAgencyName, "value"));
		System.out.println("contact: " + play.getAttributeValue(inpContact, "value"));
		System.out.println("email: " + play.getAttributeValue(intEmail, "value"));
	}

	public void clicksOnAnotherConBtn() {
		play.click(anotherConBtn, "anotherConBtn");
	}

	public void pmsChooseingPage() {
		String actaulTxt = play.textContent(pmsPage);
		Assert.assertEquals(actaulTxt, "Property Management Software");
	}

	public void choosePmsToolAndClickOnConBtn() {
		play.click(pmsTool, "Property Me Tool");
		play.click(anotherConBtn2, "Continue Button");
	}

	public void propMeLogInPage() {
		String actaulTxt = play.textContent(pmsLog);
		Assert.assertEquals(actaulTxt, "Log in");
	}

}
