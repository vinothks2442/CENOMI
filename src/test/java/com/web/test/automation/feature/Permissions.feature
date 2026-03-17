@CENOMI @Permissions
Feature: Verify the Permissions module of the cenomi web application

  Background:
    Given user is on the Permissions module page

  @Smoke
  Scenario: Tc_Permissions_001 Verify that Permissions page is displayed
    When user views the Permissions module
    Then Permissions settings should be visible

