@CENOMI @MeterDataUpload
Feature: Verify the Meter Data Upload module of the cenomi web application

  Background:
    Given user is on the Meter Data Upload module page

  @Smoke
  Scenario: Tc_MeterDataUpload_001 Verify that Meter Data Upload page is displayed
    When user views the Meter Data Upload module
    Then Meter Data Upload grid should be visible

