@CENOMI @Leases
Feature: Verify the Leases module of the cenomi web application

  Background:
    Given user is on the Leases module page

  @Smoke
  Scenario: Tc_Leases_001 Verify that Leases page is displayed
    When user views the Leases module
    Then Leases list should be visible

