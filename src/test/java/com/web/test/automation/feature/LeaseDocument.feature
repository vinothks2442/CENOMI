@CENOMI @LeaseDocument
Feature: Verify the Lease Document module of the cenomi web application

  Background:
    Given user is on the Lease Document module page

  @Smoke
  Scenario: Tc_LeaseDocument_001 Verify that Lease Document page is displayed
    When user views the Lease Document module
    Then Lease Document list should be visible

