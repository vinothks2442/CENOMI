@CENOMI @Payments
Feature: Verify the Payments module of the cenomi web application

  Background:
    Given user is on the Payments module page

  @Smoke
  Scenario: Tc_Payments_001 Verify that Payments page is displayed
    When user views the Payments module
    Then Payments list should be visible


