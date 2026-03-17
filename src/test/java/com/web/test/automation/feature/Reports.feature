@CENOMI @Reports
Feature: Verify the Reports module of the cenomi web application

  Background:
    Given user is on the Reports module page

  @Smoke
  Scenario: Tc_Reports_001 Verify that Reports page is displayed
    When user views the Reports module
    Then Reports list should be visible

