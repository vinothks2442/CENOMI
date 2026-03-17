@CENOMI @SignIn
Feature: Verify the functionality of the sign in of the cenomi web application 

Background: 
  Given user is in the cenomi landing page

  @AdminSignIn
  Scenario: Tc001 Verify the sign in functionality of the cenomi when user is already registered with cenomi platform.
  When user clicks sign in button
  And user enters the registered email and clicks on the continue button
  Then user should able to see the dashboard page if user is already registered with cenomi platform
  
@dashboard
Scenario: Tc002 Verify the dashboard page is displayed
When user clicks on the dashboard menu item
Then user should able to see the dashboard page

    
