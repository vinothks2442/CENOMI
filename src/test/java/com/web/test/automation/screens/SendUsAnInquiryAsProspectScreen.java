package com.web.test.automation.screens;
import org.yecht.Data.Str;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.automation.web.common_utils.ConfigReader;
import com.automation.web.ccl.PlayActions;


public class SendUsAnInquiryAsProspectScreen {
     PlayActions play = new PlayActions();
     private final String sendUsAnInquiryButton = "(//p[normalize-space()='Send us an inquiry'])[2]";
     private final String documentsToBeKeptHandyDialogBox = "//h3[text()='Documents to be kept handy']";
     private final String listOfDocumentsToBeKeptHandy = "//h3[text()='Documents to be kept handy']/following-sibling::ul/li";
     private final String okButton = "//button[normalize-space()='OK']";
     private final String newInquiryForm = "//h4[normalize-space()='Send Inquiry']";
     private final String signInLink = "(//a[normalize-space()='Sign In'])[2]";
     private final String numberOfStepsToCompleteTheInquiry = "//div[text()='Enter Details']";
     private final String skipButtonToSkipCompanyRegistrationNumberField = "//label[text()='Skip']";
     private final String areYouSureYouWantToProceedWithoutCRIDPopup = "//p[text()='Are you sure you want to proceed without CR ID?']";
     private final String yesButton = "//button[normalize-space()='Yes']";
     private final String noButton = "//button[normalize-space()='No']";
     private final String unitTypeRadio = "//input[@name='unit_type']/following-sibling::span";
     private final String proceedButton = "//button[normalize-space()='Proceed']";
     private final String otpVerificationPopup = "//div[normalize-space()='OTP Verification']";
     private final String otpInput = "//input[normalize-space()='OTP']";
     private final String nextButton = "//button[normalize-space()='Next']";
     private final String uploadDocumentsButton = "//button[normalize-space()='Upload Documents']";
     private final String uploadDocumentsPopup = "//div[normalize-space()='Upload Documents']";
     private final String uploadButton = "//button[normalize-space()='Upload']";
     private final String documentsUploadedSuccessfully = "//div[normalize-space()='Documents uploaded successfully']";
     private final String nextButtonEnabled = "//button[normalize-space()='Next']";
     private final String salesCategory = "//select[@name='sales_category_id']";
     private final String firstnameInput = "//input[@name='first_name']";
     private final String lastnameInput = "//input[@name='last_name']";
     private final String emailInput = "//input[@name='email']";
     private final String phoneInput = "(//div[text()='Phone']/following-sibling::input)[1]";
     private final String companyNameInput = "//input[@name='company']";
     private final String companyAddressInput = "//input[@name='company_address']";
     private final String brandNameinEnglishInput = "//input[@name='brand_name']";
     private final String BrandNameinArabicInput = "input[name='brand_name_arabic']";
     private final String selectMallDropdown = "//div[text()='Select the malls you wish to start your business']/following-sibling::div";
     private final String selectMallOption = "//div[@class=' css-pphog8-option']";
     private final String leasePeriod = "//select[@name='requested_lease_period']";
     private final String selectRentPeriod = "//select[@name='requested_rent_period']";
     private final String minimumRentInput = "//input[@name='requested_min_rent']";
     private final String maximumRentInput = "//input[@name='requested_max_rent']";
     private final String minimumAreaInput = "//input[@name='requested_min_area']";
     private final String maximumAreaInput = "//input[@name='requested_max_area']";
     private final String agreeTermsAndConditions = "#agreeToTerms";
  

public void clickSendUsAnInquiryButton() {
    play.click(sendUsAnInquiryButton, "Send Us An Inquiry button");
}

public void verifyDocumentsToBeKeptHandyDialogBox(String expectedText) {
    play.waitForVisible(documentsToBeKeptHandyDialogBox, 10000, "Documents to be kept handy dialog box");
    play.verifyText(play.textContent(documentsToBeKeptHandyDialogBox), expectedText);
}

public void clickOkButton() {
    play.click(okButton, "Ok button");
}

public void verifyNewInquiryForm() {
    play.waitForVisible(newInquiryForm, 10000, "New inquiry form");
    play.verifyText(play.textContent(newInquiryForm), "Send Inquiry");
}   

public void verifySignInLink() {
    play.waitForVisible(signInLink, 10000, "Sign in link");
    play.verifyText(play.textContent(signInLink), " Sign In");
}

public void verifyNumberOfStepsToCompleteTheInquiry() {
    play.waitForVisible(numberOfStepsToCompleteTheInquiry, 10000, "Number of steps to complete the inquiry");
    play.verifyText(play.textContent(numberOfStepsToCompleteTheInquiry), "Enter Details");
}

public void clickSkipButtonToSkipCompanyRegistrationNumberField() {
    play.click(skipButtonToSkipCompanyRegistrationNumberField, "Skip button to skip Company Registration Number field");
}

public void verifyAreYouSureYouWantToProceedWithoutCRIDPopup() {
    play.waitForVisible(areYouSureYouWantToProceedWithoutCRIDPopup, 10000, "Are you sure you want to proceed without CR ID popup");
    play.verifyText(play.textContent(areYouSureYouWantToProceedWithoutCRIDPopup), "Are you sure you want to proceed without CR ID?");
}

public void clickYesButton() {
    play.click(yesButton, "Yes button");
}



public void fillInquiryFormWithTheValidData() {
    selectUnitTypeRadio();
    selectSalesCategory();
    fillFirstname();
    fillLastname();
    fillCompanyName();
    fillCompanyAddress();
    fillBrandNameinEnglish();
    fillBrandNameinArabic();
    fillEmail();
    fillPhone();
    selectMall();
    selectLeasePeriod();
    fillMinimumArea();
    fillMaximumArea();
    selectSelectRentPeriod();
    fillMinimumRent();
    fillMaximumRent();
    checkAgreeToTerms();
            
}

public void verifyProceedButtonEnabled() {
    play.waitForVisible(proceedButton, 10000, "Proceed button");
    play.verifyText(play.textContent(proceedButton), "Proceed");
}

public void clickProceedButton() {
    play.click(proceedButton, "Proceed button");
}

public void verifyOtpVerificationPopup() {
    play.waitForVisible(otpVerificationPopup, 10000, "OTP verification popup");
    play.verifyText(play.textContent(otpVerificationPopup), "OTP verification popup");
}

public void fillOtpInput(String otp) {
    play.fill(otpInput, otp, "OTP input");
}

public void clickNextButton() {
    play.click(nextButton, "Next button");
}

public void selectUnitTypeRadio() {
    String value = ConfigReader.getValue("unitType");
    play.selectOptionFromDropdown(unitTypeRadio, value);
}

public void selectSalesCategory() {
String value = ConfigReader.getValue("salesCategory");
play.selectOptionsByValue(salesCategory, value);
}

public void fillFirstname() {
play.fill(firstnameInput, ConfigReader.getValue("firstName"), "First name");
}

public void fillLastname() {
play.fill(lastnameInput, ConfigReader.getValue("lastName"), "Last name");
}

public void fillEmail() {
play.fill(emailInput, ConfigReader.getValue("email"), "Email");
}

public void fillPhone() {
play.fill(phoneInput, ConfigReader.getValue("phone"), "Phone");
}

public void fillCompanyName() {
play.fill(companyNameInput, ConfigReader.getValue("companyName"), "Company name");
}

public void fillCompanyAddress() {
play.fill(companyAddressInput, ConfigReader.getValue("companyAddress"), "Company address");
}

public void fillBrandNameinEnglish() {
play.fill(brandNameinEnglishInput, ConfigReader.getValue("brandNameinEnglish"), "Brand name in English");
}

public void fillBrandNameinArabic() {
String arabicText = "نيك";
play.fill(BrandNameinArabicInput, arabicText, "Brand name in arabic");
}

public void selectMall() {
String mall = ConfigReader.getValue("selectMall");
play.click(selectMallDropdown, "Mall dropdown");
play.selectOptionFromDropdown(selectMallOption, mall);
}

public void selectLeasePeriod() {
play.selectOptionsByValue(leasePeriod, ConfigReader.getValue("selectLeasePeriod"));
}

public void selectSelectRentPeriod() {
play.selectOptionsByValue(selectRentPeriod, ConfigReader.getValue("selectRentPeriod"));
}

public void fillMinimumRent() {
play.fill(minimumRentInput, ConfigReader.getValue("minimumRent"), "Minimum rent");
}

public void fillMaximumRent() {
play.fill(maximumRentInput, ConfigReader.getValue("maximumRent"), "Maximum rent");
}

public void fillMinimumArea() {
play.fill(minimumAreaInput, ConfigReader.getValue("minimumArea"), "Minimum area");
}

public void fillMaximumArea() {
play.fill(maximumAreaInput, ConfigReader.getValue("maximumArea"), "Maximum area");
}

public void verifyAllDocuments(){
    String documents = ConfigReader.getValue("documents");
    play.verifyMultipleText(listOfDocumentsToBeKeptHandy, documents, "Document");

}

public void checkAgreeToTerms() {
    play.click(agreeTermsAndConditions,  "Terms And Conditions");

}

}



