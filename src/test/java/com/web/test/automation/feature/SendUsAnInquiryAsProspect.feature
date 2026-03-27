@ProspectJourney

Feature: Send Us An Inquiry As Prospect

Background: 
  Given user is in the cenomi landing page
     When user clicks on the Send Us An Inquiry button
    Then user should be able to see the dialog box with the title "Documents to be kept handy"
    And user should be able to see the list of documents to be kept handy
    When user clicks on the Ok button
    Then user should be able to see the new inquiry form
    And user should be able to see sign in link
    And user should be able to see the number of steps to complete the inquiry

    @smoke1 @fillInquiryBasicInfoForm
    Scenario: Fill In Inquiry Form
    When user clicks on the skip button to skip Company Registration Number field
    Then user should get the popup with the title "Are you sure you want to proceed without CR ID?"
    When user clicks yes button
    Then user should be able to see the new Inquiry form with the Company Registration Number field skipped
    When user fills the Inquiry form with the valid data
    Then user should be able to see the proceed button enabled
    When user clicks on the proceed button
    Then user should be able to see the otp verification popup
    When user enters the otp "123456"
    Then user should be able to move to the next step


     @fillInquiryUploadDocumentsForm
    Scenario: Fill In Inquiry Upload Documents Form
    When user clicks on the upload documents button
    Then user should be able to see the upload documents popup
    When user clicks on the upload button
    Then user should be able to see the documents uploaded successfully
    When user clicks on the next button
    Then user should be able to see the next button enabled
    When user clicks on the next button     