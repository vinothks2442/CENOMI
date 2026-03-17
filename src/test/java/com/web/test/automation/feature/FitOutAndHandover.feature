@CENOMI @FitOutAndHandover
Feature: Verify the Fit-out & Handover module of the cenomi web application

  Background:
    Given user is on the Fit-out & Handover module page

  @Smoke
  Scenario: Tc_FitOutAndHandover_001 Verify that Fit-out & Handover page is displayed
    When user views the Fit-out & Handover module
    Then Fit-out & Handover items should be visible

