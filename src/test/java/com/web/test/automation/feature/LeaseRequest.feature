@CENOMI @LeaseRequest
Feature: Verify the Lease Request module of the cenomi web application

  Background:
    Given user is on the Lease Request module page

  @Smoke
  Scenario: Tc_LeaseRequest_001 Verify that Lease Request page is displayed
    When user views the Lease Request module
    Then Lease Request list should be visible

