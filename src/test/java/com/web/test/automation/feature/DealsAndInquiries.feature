@CENOMI @DealsAndInquiries
Feature: Verify the Deals and Inquiries module of the cenomi web application

  Background:
    Given user is on the Deals and Inquiries module page

  @Smoke
  Scenario: Tc_DealsAndInquiries_001 Verify that Deals and Inquiries page is displayed
    When user views the Deals and Inquiries module
    Then Deals and Inquiries list should be visible

