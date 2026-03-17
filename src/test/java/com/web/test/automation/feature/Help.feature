@CENOMI @Help
Feature: Verify the Help module of the cenomi web application

  Background:
    Given user is on the Help module page

  @Smoke
  Scenario: Tc_Help_001 Verify that Help page is displayed
    When user views the Help module
    Then Help content should be visible

