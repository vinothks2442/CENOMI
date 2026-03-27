@UnitDiscrepancy
Feature: Unit Discrepancy Graph Validation

Background:
    Given user is in the cenomi landing page
    # When user clicks sign in button
    # And user enters the registered email and clicks on the continue button
    # Then user should able to see the dashboard page if user is already registered with cenomi platform
    When user clicks on the expand menu icon
   

  @smoke @graph @dashboard
  Scenario: Validate Unit Discrepancy graph with filters and navigation
    Given user is logged into Cenomi and on dashboard page
    When user navigates to Unit Discrepancy widget
    And user verifies graph is visible
    And user verifies year and month filters are displayed
    And user selects year "2026" and month "Mar"
    Then graph should update based on selected filters
    And graph should display discrepancy count per mall


  @functional @navigation @report
  Scenario: Validate View All navigation and report page data consistency
    Given user is on dashboard page
    When user clicks on View All button in Unit Discrepancy widget
    And user should be redirected to report page
    And user verifies mall list is displayed on left panel
    And user verifies month wise table structure
    Then discrepancy data should match with dashboard graph


  @negative @nodata
  Scenario: Validate no data scenario in graph and report
    Given user is on dashboard page
    When user selects month with no discrepancy data
    And graph should not display any data
    And system should show No Data Available message
    And user clicks on View All
    Then report page should also show empty state


  @negative @validation
  Scenario: Validate invalid filter selection and error handling
    Given user is on dashboard page
    When user selects future year and month
    And graph should not display data
    And system should handle gracefully
    And user refreshes filters again
    Then valid data should be displayed after correction


  @edge @data @duplicate
  Scenario: Validate duplicate data handling and UI consistency
    Given user is on report page
    When system loads discrepancy data
    And duplicate records exist in backend
    And user verifies table data
    And user compares graph values
    Then duplicate values should not be counted twice


  @edge @ui @filters
  Scenario: Validate dropdown behavior and rapid filter changes
    Given user is on dashboard page
    When user clicks on year dropdown
    And user selects multiple filters quickly
    And system refreshes graph
    And user verifies graph stability
    Then no UI break or incorrect data should be displayed