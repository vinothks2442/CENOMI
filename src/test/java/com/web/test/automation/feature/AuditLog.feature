@CENOMI @AuditLog
Feature: Verify the Audit Log module of the cenomi web application

  Background:
    Given user is on the Audit Log module page

  @Smoke
  Scenario: Tc_AuditLog_001 Verify that Audit Log page is displayed
    When user views the Audit Log module
    Then Audit Log entries should be visible

