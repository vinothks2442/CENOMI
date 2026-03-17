@CENOMI @RddDashboard
Feature: Verify the RDD Dashboard module of the cenomi web application

  Background:
    Given user is on the RDD Dashboard module page

  @Smoke
  Scenario: Tc_RddDashboard_001 Verify that RDD Dashboard page is displayed
    When user views the RDD Dashboard module
    Then RDD Dashboard widgets and summary information should be visible

