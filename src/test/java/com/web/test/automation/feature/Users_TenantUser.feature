@CENOMI @Users @TenantUser
Feature: Verify the Tenant User submodule under Users

  Background:
    Given user is on the Tenant User page under Users module

  @Smoke
  Scenario: Tc_Users_TenantUser_001 Verify that Tenant User list is visible
    When user views the Tenant User list
    Then Tenant User records should be visible

