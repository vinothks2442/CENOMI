@CENOMI @RddDocuments
Feature: Verify the RDD Documents module of the cenomi web application

  Background:
    Given user is on the RDD Documents module page

  @Smoke
  Scenario: Tc_RddDocuments_001 Verify that RDD Documents page is displayed
    When user views the RDD Documents module
    Then RDD Documents list should be visible

