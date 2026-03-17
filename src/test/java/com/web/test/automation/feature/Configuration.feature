@CENOMI @Configuration
Feature: Verify the Configuration module of the cenomi web application

  Background:
    Given user is on the Configuration module page

  @Smoke
  Scenario: Tc_Configuration_001 Verify that Configuration page is displayed
    When user views the Configuration module
    Then Configuration settings should be visible

