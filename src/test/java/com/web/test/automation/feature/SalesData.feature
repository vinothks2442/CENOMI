@CENOMI @SalesData
Feature: Verify the Sales Data module of the cenomi web application

  Background:
    Given user is on the Sales Data module page

  @Smoke
  Scenario: Tc_SalesData_001 Verify that Sales Data page is displayed
    When user views the Sales Data module
    Then Sales Data summary should be visible

