@CENOMI @Users
Feature: Verify the Users module of the cenomi web application

  Background:
    Given user is on the Users module page

  @Smoke
  Scenario: Tc_Users_001 Verify that Users page is displayed
    When user views the Users module
    Then Users summary information should be visible

