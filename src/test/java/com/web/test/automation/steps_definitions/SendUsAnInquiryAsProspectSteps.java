package com.web.test.automation.steps_definitions;
import io.cucumber.java.en.*;
import com.web.test.automation.screens.SendUsAnInquiryAsProspectScreen;

public class SendUsAnInquiryAsProspectSteps {

    SendUsAnInquiryAsProspectScreen sendUsAnInquiryAsProspect = new SendUsAnInquiryAsProspectScreen();

    @When("user clicks on the Send Us An Inquiry button")
    public void userClicksOnTheSendUsAnInquiryButton() {
        sendUsAnInquiryAsProspect.clickSendUsAnInquiryButton();
    }

    @Then("user should be able to see the dialog box with the title {string}")
    public void userShouldBeAbleToSeeTheDialogBoxWithTheTitle(String title) {
        sendUsAnInquiryAsProspect.verifyDocumentsToBeKeptHandyDialogBox(title);
    }

    @Then("user should be able to see the list of documents to be kept handy")
    public void userShouldBeAbleToSeeTheListOfDocumentsToBeKeptHandy() {
        sendUsAnInquiryAsProspect.verifyAllDocuments();
    }

    @When("user clicks on the Ok button")
    public void userClicksOnTheOkButton() {
        sendUsAnInquiryAsProspect.clickOkButton();
    }
    
    @Then("user should be able to see the new inquiry form")
    public void userShouldBeAbleToSeeTheNewInquiryForm() {
       sendUsAnInquiryAsProspect.verifyNewInquiryForm();
    }

    @Then("user should be able to see sign in link")
    public void userShouldBeAbleToSeeSignInLink() {
        sendUsAnInquiryAsProspect.verifySignInLink();
    }

    @Then("user should be able to see the number of steps to complete the inquiry")
    public void userShouldBeAbleToSeeTheNumberOfStepsToCompleteTheInquiry() {
        sendUsAnInquiryAsProspect.verifyNumberOfStepsToCompleteTheInquiry();
    }

    @When("user clicks on the skip button to skip Company Registration Number field")
    public void userClicksOnTheSkipButtonToSkipCompanyRegistrationNumberField() {
        sendUsAnInquiryAsProspect.clickSkipButtonToSkipCompanyRegistrationNumberField();
    }

    @Then("user should get the popup with the title {string}")
    public void userShouldGetThePopupWithTheTitle(String title) {
        sendUsAnInquiryAsProspect.verifyAreYouSureYouWantToProceedWithoutCRIDPopup();
    }

    @When("user clicks yes button")
    public void userClicksYesButton() {
        sendUsAnInquiryAsProspect.clickYesButton();
    }

    @Then("user should be able to see the new Inquiry form with the Company Registration Number field skipped")
    public void userShouldBeAbleToSeeTheNewInquiryFormWithTheCompanyRegistrationNumberFieldSkipped() {
       
    }

    @When("user fills the Inquiry form with the valid data")
    public void userFillsTheInquiryFormWithTheValidData() {
        sendUsAnInquiryAsProspect.fillInquiryFormWithTheValidData();
    }

    @Then("user should be able to see the proceed button enabled")
    public void userShouldBeAbleToSeeTheProceedButtonEnabled() {
       sendUsAnInquiryAsProspect.verifyProceedButtonEnabled();
    }

    @When("user clicks on the proceed button")
    public void userClicksOnTheProceedButton() {
        sendUsAnInquiryAsProspect.clickProceedButton();
    }   

    @Then("user should be able to see the otp verification popup")
    public void userShouldBeAbleToSeeTheOtpVerificationPopup() {
        System.out.println("User should be able to see the otp verification popup");
    }

    @When("user enters the otp {string}")
    public void userEntersTheOtp(String otp) {
        System.out.println("User enters the otp " + otp);
    }   

    @Then("user should be able to move to the next step")
    public void userShouldBeAbleToMoveToTheNextStep() {
        System.out.println("User should be able to move to the next step");
    }

    @When("user clicks on the upload documents button")
    public void userClicksOnTheUploadDocumentsButton() {
        System.out.println("User clicks on the upload documents button");
    }   

    @Then("user should be able to see the upload documents popup")
    public void userShouldBeAbleToSeeTheUploadDocumentsPopup() {
        System.out.println("User should be able to see the upload documents popup");
    }

    @When("user clicks on the upload button")
    public void userClicksOnTheUploadButton() {
        System.out.println("User clicks on the upload button");
    }   

    @Then("user should be able to see the documents uploaded successfully")
    public void userShouldBeAbleToSeeTheDocumentsUploadedSuccessfully() {
        System.out.println("User should be able to see the documents uploaded successfully");
    }

    @When("user clicks on the next button")
    public void userClicksOnTheNextButton() {
        System.out.println("User clicks on the next button");
    }   

    @Then("user should be able to see the next button enabled")
    public void userShouldBeAbleToSeeTheNextButtonEnabled() {
        System.out.println("User should be able to see the next button enabled");
    }

}
