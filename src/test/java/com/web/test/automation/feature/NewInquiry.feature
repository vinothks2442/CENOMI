@CENOMI @NewInquiry
Feature: Verify the New Inquiry module of the cenomi web application

  Background:
    Given user is on the New Inquiry module page

  @Smoke
  Scenario: Tc_NewInquiry_001 Verify that New Inquiry page is displayed
    When user views the New Inquiry module
    Then New Inquiry form should be visible

