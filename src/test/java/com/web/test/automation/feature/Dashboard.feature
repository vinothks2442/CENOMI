@CENOMI @Dashboard
Feature: Verify the Dashboard module of the cenomi web application

  Background:
    Given user is on the Dashboard module page

  @Smoke
  Scenario: Tc_Dashboard_001 Verify that Dashboard page is displayed
    When user views the Dashboard module
    Then Dashboard widgets and summary information should be visible

