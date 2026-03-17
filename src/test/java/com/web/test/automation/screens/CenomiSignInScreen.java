package com.web.test.automation.screens;

import com.automation.web.ccl.PlayActions;
import com.automation.web.common_utils.MicrosoftLoginUtil;
import com.automation.web.common_utils.ConfigReader;
import junit.framework.Assert;

public class CenomiSignInScreen {
	
	PlayActions play = new PlayActions();
	MicrosoftLoginUtil microsoftLoginUtil = new MicrosoftLoginUtil();
	
	String signInButton = "(//a[text()='Sign In'])[2]";
	String emailInput = "//input[@type='email']";
	String nextButton = "//input[@type='submit']";
	String sendCodeButton = "//button[@data-testid='primaryButton']";
	String otpInput = "//input[@inputmode='numeric']";
	String dashboardLocator = "//p[text()='Dashboard']";
	String whoYouArePage = "//p[text()='Please tell us who you are']";
	String agencyAdm = "//h3[text()='Agency Admin']";
	String conBtn1 = "//button[text()='Continue']";

	public void cenomiLandingPage() {
		play.navigate(ConfigReader.getValue("uatUrl"));
	}

	public void clickSignInButton() {
		play.click(signInButton, "SignIn button");
		play.click(nextButton, "Next button");
	}

	public void enterRegisteredEmail() throws Exception {
		play.fill(emailInput, ConfigReader.getValue("adminEmail"), "Admin email");
		play.click(nextButton, "Next button");
		play.click(sendCodeButton, "Send code button");
		Thread.sleep(150000);
	}

	public void verifyDashboardPage() throws InterruptedException {
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		play.waitForVisible(dashboardLocator, 5000, "Dashboard Menu");
		play.verifyText(play.textContent(dashboardLocator), "Dashboard");
	}

	public void clickDashboardMenuItem() {
		play.click(dashboardLocator, "Dashboard Menu");
	}

	public void verifyDashboardPageIsDisplayed() {
		play.waitForVisible(dashboardLocator, 5000, "Dashboard Menu");
		play.verifyText(play.textContent(dashboardLocator), "Dashboard");
	}

}
