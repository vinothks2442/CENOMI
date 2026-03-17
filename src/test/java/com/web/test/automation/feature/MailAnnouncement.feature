@CENOMI @MailAnnouncement
Feature: Verify the Mail Announcement module of the cenomi web application

  Background:
    Given user is on the Mail Announcement module page

  @Smoke
  Scenario: Tc_MailAnnouncement_001 Verify that Mail Announcement page is displayed
    When user views the Mail Announcement module
    Then Mail Announcement list should be visible

