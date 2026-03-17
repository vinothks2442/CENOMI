@ServiceRequest
Feature: Service Request (SR) - Excel Coverage (TC_001 to TC_034)

  # Source: Excel sheet "Service Request" tab
  # Link: https://docs.google.com/spreadsheets/d/1VX7sR1NI-2IuunCyz9pmODaLPXAi4kqO2FTxty5OC4I/edit?gid=0#gid=0

  Background:
    Given user is in the cenomi landing page
    # When user clicks sign in button
    # And user enters the registered email and clicks on the continue button
    # Then user should able to see the dashboard page if user is already registered with cenomi platform
    When user clicks on the expand menu icon
    And user clicks on service request menu
    Then service request page should be displayed

  # TC_001
  @TC_001 @SR_List_Load
  Scenario: TC_001 Verify Service Request module loads
    Then service request page should show list view controls
    And service request list should load successfully
    And service request search input should be available
    And service request filter button should be available
    And service request create button should be available

  # TC_002
  @TC_002 @SR_Create_Button
  Scenario: TC_002 Verify '+ Service Request' button opens form
    When user clicks create service request button
    Then service request create form should be displayed
    And service request subject field should be visible
    And service request description field should be visible
    And service request submit button should be visible

  # TC_003
  @TC_003 @SR_Subject_Mandatory
  Scenario: TC_003 Validate mandatory Subject field
    When user clicks create service request button
    And user leaves service request subject empty
    And user submits service request form
    Then subject validation message should be displayed
    And service request should not be submitted

  # TC_004
  @TC_004 @SR_Subject_MaxLength
  Scenario: TC_004 Validate Subject max length (255)
    When user clicks create service request button
    And user enters service request subject with more than 255 characters
    Then service request subject input should be restricted to 255 characters
    And service request submit button should remain available for valid inputs
    And service request form should stay open

  # TC_005
  @TC_005 @SR_Category_Values
  Scenario: TC_005 Validate category dropdown values
    When user clicks create service request button
    Then service request category dropdown should contain configured values
    And service request category dropdown should include "INQUIRY"
    And service request category dropdown should include "WORK_REQUEST"
    And service request category dropdown should include "WORK_PERMIT"

  # TC_006, TC_007, TC_008, TC_009
  @TC_006 @TC_007 @TC_008 @TC_009 @SR_Search
  Scenario Outline: TC_006-TC_009 Search service requests
    When user searches service request using "<searchValue>"
    Then service request search should show "<expectedOutcome>"
    And service request list should remain stable after search
    And user should be able to clear service request search
    And service request list should refresh to default results

    Examples:
      | searchValue | expectedOutcome |
      | 8887        | MATCH_FOUND     |
      | 88          | MATCH_FOUND     |
      | INVALID_$$$ | NO_RESULTS      |
      |            | HANDLED_EMPTY   |

  # TC_010 to TC_015 (single filters)
  @TC_010 @TC_011 @TC_012 @TC_013 @TC_014 @TC_015 @SR_Filter_Single
  Scenario Outline: TC_010-TC_015 Filter service requests with single filter
    When user opens service request filter panel
    And user applies service request filter "<filterType>" with value "<filterValue>"
    Then service request results should be filtered by "<filterType>"
    And service request filter should be applied
    And service request list should load successfully

    Examples:
      | filterType | filterValue |
      | Month      | January     |
      | Year       | 2026        |
      | Status     | Active      |
      | Category   | INQUIRY     |
      | Mall       | Any         |
      | DateRange  | Any         |

  # TC_016 to TC_019 (sorting)
  @TC_016 @TC_017 @TC_018 @TC_019 @SR_Sort
  Scenario Outline: TC_016-TC_019 Sort service requests
    When user sorts service request list by "<column>" in "<direction>" order
    Then service request list should be sorted by "<column>" in "<direction>" order
    And service request list should load successfully
    And service request list should remain stable after sort
    And service request page should show list view controls

    Examples:
      | column      | direction |
      | Updated Date| ASC       |
      | Updated Date| DESC      |
      | SR Number   | ASC       |
      | SR Number   | DESC      |

  # TC_020 to TC_028 (multi-filters + sort)
  @TC_020 @TC_021 @TC_022 @TC_023 @TC_024 @TC_025 @TC_026 @TC_027 @TC_028 @SR_Filter_Multi
  Scenario Outline: TC_020-TC_028 Apply multiple filters then sort
    When user opens service request filter panel
    And user applies service request filter "<filter1Type>" with value "<filter1Value>"
    And user applies service request filter "<filter2Type>" with value "<filter2Value>"
    And user applies service request filter "<filter3Type>" with value "<filter3Value>"
    And user sorts service request list by "<sortColumn>" in "<sortDirection>" order
    Then service request results should satisfy applied filters
    And service request list should be sorted by "<sortColumn>" in "<sortDirection>" order
    And user clears all service request filters

    Examples:
      | filter1Type | filter1Value | filter2Type | filter2Value | filter3Type | filter3Value | sortColumn   | sortDirection |
      | Month       | January      | Status      | Active       | Category    | INQUIRY      | Updated Date | DESC          |
      | Category    | INQUIRY      | Mall        | Any          | Status      | Active       | SR Number    | ASC           |

  # TC_029 to TC_034 (pagination)
  @TC_029 @TC_030 @TC_031 @TC_032 @TC_033 @TC_034 @SR_Pagination
  Scenario: TC_029-TC_034 Verify pagination controls and navigation
    Then service request pagination controls should be visible
    When user navigates to next service request page
    Then service request page number should change
    When user navigates to previous service request page
    Then service request page number should change
    And service request list should load successfully

  # JSON coverage: "Service Request Detiled View" (SR details navigation + tabs)
  @SR_DetailView
  Scenario: Verify service request detailed view opens from list row
    When user opens first service request from list
    Then service request details view should be displayed
    And service request details should show SR number
    And service request details should show created date
    And service request details should show category and subcategory

  @SR_DetailView_Tabs
  Scenario: Verify service request detailed view tabs are accessible
    When user opens first service request from list
    Then service request details view should be displayed
    When user opens SR Details tab in detailed view
    Then SR Details section should be visible
    When user opens Approval List tab in detailed view
    Then Approval List section should be visible
    When user opens Attachments tab in detailed view
    Then Attachments section should be visible

  @SR_ApprovalList
  Scenario: Verify approval list contains approver roles and statuses
    When user opens first service request from list
    And user opens Approval List tab in detailed view
    Then approval list should contain at least 1 approver entry
    And each approver entry should show role name
    And each approver entry should show approval status
    And approval list should remain visible

  @SR_Messages
  Scenario: Verify messages tab allows submitting comment successfully
    When user opens first service request from list
    And user opens Messages section in detailed view
    And user enters service request comment "Okay"
    And user submits service request comment
    Then comment should appear in message list
    And comment toast notification should be displayed

  # JSON coverage: "Service request one" (Create SR page + SR details fields + attachment + phone validation)
  @SR_Create_Basic
  Scenario: Verify user can start creating a new service request and view SR details section
    When user clicks create service request button
    Then service request create form should be displayed
    When user selects service request category "INQUIRY" and subcategory "GENERAL"
    Then SR Details section should be visible
    And service request subject field should be visible
    And service request description field should be visible

  @SR_Create_SubjectDescription
  Scenario Outline: Verify create SR allows entering subject and description
    When user clicks create service request button
    And user selects service request category "<category>" and subcategory "<subcategory>"
    And user enters service request subject "<subject>"
    And user enters service request description "<description>"
    Then service request subject value should be "<subject>"
    And service request description value should be "<description>"

    Examples:
      | category     | subcategory        | subject                 | description              |
      | INQUIRY      | GENERAL            | General Inquiry Test    | Test                     |
      | WORK_PERMIT  | CONSTRUCTION_HOT   | Work Permit hot         | Work permit hot \| Desc  |

  @SR_Create_InvalidPhone
  Scenario: Verify invalid phone number shows validation error in SR create form
    When user clicks create service request button
    And user selects service request category "WORK_PERMIT" and subcategory "CONSTRUCTION_HOT"
    And user enters contractor mobile number as "+966 9"
    Then contractor mobile number validation message should be displayed
    And service request create form should be displayed

  @SR_Create_Attachment
  Scenario: Verify attachment upload shows selected file name
    When user clicks create service request button
    And user selects service request category "WORK_PERMIT" and subcategory "CONSTRUCTION_HOT"
    And user uploads service request attachment "Dummy.pdf"
    Then uploaded attachment file name should be displayed as "Dummy.pdf"
    And service request create form should be displayed

  @SR_Create_Inquiry_request
  Scenario: Verify inquiry request is created successfully
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "Test Inquiry"
    And user enters service request description "Test Inquiry Description"
    And user submits service request form
    Then service request should be submitted successfully
    And user navigates to service request list from success message

  ########################################################################################################
  # E2E automation coverage: Complete Service Request (SR) creation flow
  # Each scenario covers full flow: open SR module -> + Service Request -> fill form -> (upload if needed)
  # -> Submit -> Verify success/validation
  ########################################################################################################

  # 1) Positive Scenarios
  @SR_E2E_Positive @SR_E2E_AllValid
  Scenario: Successful SR creation with all valid inputs
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user enters service request subject "E2E - SR creation valid"
    And user selects service request company "Saudi Telecom Company"
    And user selects tenant contact "rinosha Rajan - Service Provider"
    And user selects lease_brand mall "t0103430 - LORA - Nakheel Mall"
    And user waits "2" seconds for dropdown options to load
    And user enters service request description "E2E - SR description valid"
    And user enters service request notes "E2E - SR notes valid"
    And user uploads service request attachments:
      | fileName   |
      | Dummy.pdf  |
      | Dummy.png  |
    And user submits service request form
    Then service request should be submitted successfully

  @SR_E2E_Positive @SR_E2E_OptionalEmpty
  Scenario: Successful SR creation with optional fields left empty
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Optional empty"
    And user enters service request description "E2E - Only mandatory fields filled"
    And user submits service request form
    Then service request should be submitted successfully

  @SR_E2E_Positive @SR_E2E_SingleUpload
  Scenario: Successful SR creation with single file upload
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Single upload"
    And user enters service request description "E2E - Single upload description"
    And user uploads service request attachments:
      | fileName   |
      | Dummy.pdf  |
    And user submits service request form
    Then service request should be submitted successfully

  @SR_E2E_Positive @SR_E2E_MultiUpload
  Scenario: Successful SR creation with multiple file uploads
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Multiple uploads"
    And user enters service request description "E2E - Multiple uploads description"
    And user uploads service request attachments:
      | fileName    |
      | Dummy.pdf   |
      | Dummy.png   |
    And user submits service request form
    Then service request should be submitted successfully

  @SR_E2E_Positive @SR_E2E_VerifyInList
  Scenario: Verify SR appears in SR list after successful submission
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Verify in list"
    And user enters service request description "E2E - Verify SR appears in list"
    And user submits service request form
    Then service request should be submitted successfully
    When user navigates to service request list from success message
    Then created service request should appear in service request list

  # 2) Mandatory Field Validation (each mandatory field = separate scenario)
  @SR_E2E_Mandatory @SR_E2E_Mandatory_Category
  Scenario: Category not selected
    When user clicks create service request button
    And user leaves service request category unselected
    And user submits service request form
    Then validation message for "Category" should be displayed
    And service request should not be submitted

  @SR_E2E_Mandatory @SR_E2E_Mandatory_Subcategory
  Scenario: Subcategory not selected
    When user clicks create service request button
    And user selects service request category "INQUIRY"
    And user leaves service request subcategory unselected
    And user enters service request subject "E2E - Missing subcategory"
    And user enters service request description "E2E - Missing subcategory description"
    And user submits service request form
    Then validation message for "Subcategory" should be displayed
    And service request should not be submitted

  @SR_E2E_Mandatory @SR_E2E_Mandatory_Subject
  Scenario: Subject / Title empty
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user leaves service request subject empty
    And user enters service request description "E2E - Missing subject"
    And user submits service request form
    Then validation message for "Subject" should be displayed
    And service request should not be submitted

  @SR_E2E_Mandatory @SR_E2E_Mandatory_Description
  Scenario: Description empty
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Missing description"
    And user leaves service request description empty
    And user submits service request form
    Then validation message for "Description" should be displayed
    And service request should not be submitted

  @SR_E2E_Mandatory @SR_E2E_Mandatory_Mall
  Scenario: Location / Mall not selected
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user leaves service request mall unselected
    And user enters service request subject "E2E - Missing mall"
    And user enters service request description "E2E - Missing mall description"
    And user submits service request form
    Then validation message for "Mall" should be displayed
    And service request should not be submitted

  # 3) Input Validation
  @SR_E2E_InputValidation @SR_E2E_Subject_TooLong
  Scenario: Subject exceeds maximum character limit
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject with more than 255 characters
    And user enters service request description "E2E - Description valid"
    Then service request subject input should be restricted to 255 characters

  @SR_E2E_InputValidation @SR_E2E_Subject_SpacesOnly
  Scenario: Subject with only spaces
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "     "
    And user enters service request description "E2E - Description valid"
    And user submits service request form
    Then validation message for "Subject" should be displayed
    And service request should not be submitted

  @SR_E2E_InputValidation @SR_E2E_Subject_SpecialChars
  Scenario: Subject with special characters
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "@@@###$$$ SR - Special"
    And user enters service request description "E2E - Description valid"
    And user submits service request form
    Then service request should be submitted successfully

  @SR_E2E_InputValidation @SR_E2E_Description_TooLong
  Scenario: Description exceeding max length
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Description too long"
    And user enters service request description with more than 2000 characters
    And user submits service request form
    Then validation message for "Description" should be displayed
    And service request should not be submitted

  @SR_E2E_InputValidation @SR_E2E_TrimSpaces
  Scenario: Leading and trailing spaces in inputs
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "  E2E - Trim subject  "
    And user enters service request description "  E2E - Trim description  "
    And user submits service request form
    Then service request should be submitted successfully

  # 4) File Upload Validation
  @SR_E2E_FileUpload @SR_E2E_ValidFileTypes
  Scenario: Upload valid file types
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Valid file types"
    And user enters service request description "E2E - Upload pdf and png"
    And user uploads service request attachments:
      | fileName   |
      | Dummy.pdf  |
      | Dummy.png  |
    Then uploaded attachment file name should contain "Dummy.pdf"
    And uploaded attachment file name should contain "Dummy.png"

  @SR_E2E_FileUpload @SR_E2E_UnsupportedFileType
  Scenario: Upload unsupported file types
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Unsupported file type"
    And user enters service request description "E2E - Upload exe should fail"
    And user uploads service request attachments:
      | fileName    |
      | Dummy.exe   |
    Then validation message for "Attachment" should be displayed
    And service request should not be submitted

  @SR_E2E_FileUpload @SR_E2E_FileTooLarge
  Scenario: Upload file exceeding allowed size
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Large file upload"
    And user enters service request description "E2E - Large file should fail"
    And user uploads a large service request attachment "DummyLarge.pdf" of size "6000" KB
    Then validation message for "Attachment" should be displayed
    And service request should not be submitted

  @SR_E2E_FileUpload @SR_E2E_MultiFileUpload
  Scenario: Upload multiple files
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Multi file upload"
    And user enters service request description "E2E - Upload multiple files"
    And user uploads service request attachments:
      | fileName    |
      | Dummy.pdf   |
      | Dummy.png   |
    Then uploaded attachment file name should contain "Dummy.pdf"
    And uploaded attachment file name should contain "Dummy.png"

  @SR_E2E_FileUpload @SR_E2E_RemoveUpload
  Scenario: Remove uploaded file before submission
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Remove attachment"
    And user enters service request description "E2E - Remove attachment before submit"
    And user uploads service request attachments:
      | fileName   |
      | Dummy.pdf  |
    And user removes uploaded attachment "Dummy.pdf"
    Then uploaded attachment file name should not contain "Dummy.pdf"

  @SR_E2E_FileUpload @SR_E2E_DuplicateUpload
  Scenario: Upload duplicate files
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Duplicate upload"
    And user enters service request description "E2E - Upload duplicate files"
    And user uploads service request attachments:
      | fileName   |
      | Dummy.pdf  |
      | Dummy.pdf  |
    Then validation message for "Attachment" should be displayed

  # 5) Negative Scenarios
  @SR_E2E_Negative @SR_E2E_MultipleMandatoryEmpty
  Scenario: Submit form with multiple mandatory fields empty
    When user clicks create service request button
    And user leaves service request category unselected
    And user leaves service request subject empty
    And user leaves service request description empty
    And user submits service request form
    Then validation message for "Category" should be displayed
    And validation message for "Subject" should be displayed
    And validation message for "Description" should be displayed
    And service request should not be submitted

  @SR_E2E_Negative @SR_E2E_InvalidDropdownCombination
  Scenario: Submit form with invalid dropdown combinations
    When user clicks create service request button
    And user selects service request category "WORK_PERMIT" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Invalid combination"
    And user enters service request description "E2E - Invalid dropdown combination"
    And user submits service request form
    Then validation message for "Subcategory" should be displayed
    And service request should not be submitted

  @SR_E2E_Negative @SR_E2E_SubmitWithoutAnyField
  Scenario: Attempt to submit without filling any field
    When user clicks create service request button
    And user submits service request form
    Then validation message for "Category" should be displayed
    And validation message for "Subject" should be displayed
    And validation message for "Description" should be displayed
    And service request should not be submitted

  # 6) Edge Cases
  @SR_E2E_Edge @SR_E2E_VeryLongSubject
  Scenario: Very long subject text
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject with more than 255 characters
    And user enters service request description "E2E - Description valid"
    Then service request subject input should be restricted to 255 characters

  @SR_E2E_Edge @SR_E2E_VeryLargeDescription
  Scenario: Very large description text
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Large description"
    And user enters service request description with more than 2000 characters
    And user submits service request form
    Then validation message for "Description" should be displayed
    And service request should not be submitted

  @SR_E2E_Edge @SR_E2E_RapidSubmissions
  Scenario: Rapid multiple submissions
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Rapid submit"
    And user enters service request description "E2E - Rapid submit description"
    And user rapidly submits service request form "3" times
    Then service request should be submitted successfully

  @SR_E2E_Edge @SR_E2E_NetworkDelay
  Scenario: Network delay during submission
    When user clicks create service request button
    And user selects service request category "INQUIRY" and subcategory "GENERAL"
    And user selects service request mall "Any"
    And user enters service request subject "E2E - Network delay"
    And user enters service request description "E2E - Submission waits for response"
    And user submits service request form with extended wait time
    Then service request should be submitted successfully