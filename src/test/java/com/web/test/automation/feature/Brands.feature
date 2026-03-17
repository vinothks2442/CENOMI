@CENOMI @Brands
Feature: Verify the Brands module of the cenomi web application

  Background:
    Given user is on the Brands module page

  @Smoke
  Scenario: Tc_Brands_001 Verify that Brands page is displayed
    When user views the Brands module
    Then Brands list should be visible

