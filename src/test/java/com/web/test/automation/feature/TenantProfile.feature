@CENOMI @TenantProfile
Feature: Verify the Tenant Profile module of the cenomi web application

  Background:
    Given user is on the Tenant Profile module page

  @Smoke
  Scenario: Tc_TenantProfile_001 Verify that Tenant Profile page is displayed
    When user views the Tenant Profile module
    Then Tenant Profile details should be visible

