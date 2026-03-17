@CENOMI @CommunicationCenter
Feature: Verify the Communication Center module of the cenomi web application

  Background:
    Given user is on the Communication Center module page

  @Smoke
  Scenario: Tc_CommunicationCenter_001 Verify that Communication Center page is displayed
    When user views the Communication Center module
    Then Communication Center items should be visible

