@RTB @SignIn
Feature: Verify the functionality of the sign in of the rtb web application 

Background: 
  Given user is in the rtb landing page

  @AgencySignIn
  Scenario: Tc001 Verify the sign in functionality of the rtb when user is already registered
  When user clicks in get started button
  Then user should able to see who you are page
  When user chooses the agency admin role and clicks on continue button
  Then user should able to see enter your email page
  When user enters the email and clicks on the continue button
  Then user should able to see otp page
  When user enters the otp and clicks on the verity otp button
  Then user should able to see the dashboard page if user is already registered

  

    
