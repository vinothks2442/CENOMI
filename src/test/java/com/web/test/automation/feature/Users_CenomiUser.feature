@CENOMI @Users @CenomiUser
Feature: Verify the Cenomi User submodule under Users

  Background:
    Given user is on the Cenomi User page under Users module

  @Smoke
  Scenario: Tc_Users_CenomiUser_001 Verify that Cenomi User list is visible
    When user views the Cenomi User list
    Then Cenomi User records should be visible

