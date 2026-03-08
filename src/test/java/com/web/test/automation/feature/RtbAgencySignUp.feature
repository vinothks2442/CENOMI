@RTB @Signup
Feature: Verify the functionality of the sign in of the rtb web application

  Background: 
    Given user is in the rtb landing page

  @AgencySignup
  Scenario: Tc001 Verify the sign up functionality of the rtb when user is not registered it should go to onboarding
    When user clicks in get started button
    Then user should able to see who you are page
    When user chooses the agency admin role and clicks on continue button
    Then user should able to see enter your email page
    When user enters the new user email "test@gmail.com" and clicks on the continue button
    Then user should able to see otp page
    When user enters the otp "654321"  and clicks on the verity otp button
    Then user should able to see the onboarding form
    When user fills the onboarding details
      | details        | values          |
      | bussiness name | example pvt ltd |
      | trading name   | hsgdh           |
      | pincode        |            4327 |
    And user clicks on continue button
    Then user should able to see hey its great to see you page
    When user clicks on back button
    Then user should able to see details still visible
    And user clicks on continue button
    And user clicks on another continue button
    Then user should able to see property management software choosing page
    When user choose the property me software and clicks on the continue button
    Then user should able to see the property me log in page
