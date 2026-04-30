package com.web.test.automation.steps_definitions;
import com.web.test.automation.screens.ServiceRequestScreen;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class ServiceRequestSteps {

	ServiceRequestScreen serviceRequest = new ServiceRequestScreen();

	@When("user clicks on the expand menu icon")
	public void clickExpandMenuIcon() {
		serviceRequest.openExpandMenuIcon();
	}

	@When("user clicks on service request menu")
	public void openServiceRequestMenu() {
		serviceRequest.openServiceRequestMenu();
	}

	@Then("service request page should be displayed")
	public void verifyServiceRequestPage() {
		serviceRequest.verifyServiceRequestPage();
	}

	@When("user clicks create service request button")
	public void createSR() {
		serviceRequest.clickCreateServiceRequest();
	}

	@Then("service request page should show list view controls")
	public void verifyListViewControls() {
		serviceRequest.assertListViewControlsVisible();
	}

	@Then("service request list should load successfully")
	public void verifyListLoads() {
		serviceRequest.assertListLoadedOrEmptyState();
	}

	@Then("service request search input should be available")
	public void verifySearchAvailable() {
		serviceRequest.assertSearchAvailable();
	}

	@Then("service request filter button should be available")
	public void verifyFilterAvailable() {
		serviceRequest.assertFilterAvailable();
	}

	@Then("service request create button should be available")
	public void verifyCreateAvailable() {
		serviceRequest.assertCreateButtonAvailable();
	}

	@Then("service request create form should be displayed")
	public void verifyCreateForm() {
		serviceRequest.assertCreateFormVisible();
	}

	@Then("service request subject field should be visible")
	public void verifySubjectVisible() {
		serviceRequest.assertSubjectFieldVisible();
	}

	@Then("service request description field should be visible")
	public void verifyDescriptionVisible() {
		serviceRequest.assertDescriptionFieldVisible();
	}

	@Then("service request submit button should be visible")
	public void verifySubmitButtonVisible() {
		serviceRequest.assertSubmitButtonVisible();
	}

	@When("user leaves service request subject empty")
	public void leaveSubjectEmpty() {
		serviceRequest.clearSubject();
	}

	@When("user leaves service request description empty")
	public void leaveDescriptionEmpty() {
		serviceRequest.clearDescription();
	}

	@When("user submits service request form")
	public void submitCreateForm() throws InterruptedException {
		serviceRequest.submitRequestForm();
	}

	@When("user submits service request form with extended wait time")
	public void submitCreateFormExtendedWait() throws InterruptedException {
		serviceRequest.submitRequestFormWithExtendedWait();
	}

	@When("user rapidly submits service request form {string} times")
	public void rapidSubmit(String times) {
		serviceRequest.rapidSubmit(times);
	}

	@Then("subject validation message should be displayed")
	public void subjectValidationDisplayed() {
		serviceRequest.assertSubjectValidationVisible();
	}

	@Then("validation message for {string} should be displayed")
	public void validationForField(String fieldName) {
		serviceRequest.assertValidationMessageForField(fieldName);
	}

	@Then("service request should not be submitted")
	public void srNotSubmitted() {
		serviceRequest.assertRequestNotSubmitted();
	}

	@Then("service request should be submitted successfully")
	public void srSubmittedSuccessfully() {
		serviceRequest.assertServiceRequestSubmittedSuccessfully();
	}

	@When("user navigates to service request list from success message")
	public void goToListFromSuccess() {
		serviceRequest.goToServiceRequestsFromSuccessDialog();
	}

	@Then("created service request should appear in service request list")
	public void createdSrShouldAppearInList() {
		serviceRequest.assertCreatedServiceRequestPresentInList();
	}

	@When("user enters service request subject with more than 255 characters")
	public void enterSubjectMoreThan255() {
		serviceRequest.enterSubjectMoreThan255Chars();
	}

	@Then("service request subject input should be restricted to 255 characters")
	public void assertSubjectRestricted() {
		serviceRequest.assertSubjectMaxLengthRestrictedTo255();
	}

	@Then("service request submit button should remain available for valid inputs")
	public void assertSubmitAvailable() {
		serviceRequest.assertSubmitButtonVisible();
	}

	@Then("service request form should stay open")
	public void assertFormOpen() {
		serviceRequest.assertCreateFormVisible();
	}

	@Then("service request category dropdown should contain configured values")
	public void assertCategoryConfigured() {
		serviceRequest.assertCategoryDropdownHasValues();
	}

	@Then("service request category dropdown should include {string}")
	public void assertCategoryIncludes(String expected) {
		serviceRequest.assertCategoryDropdownIncludes(expected);
	}

	@When("user searches service request using {string}")
	public void searchServiceRequest(String searchValue) {
		serviceRequest.searchServiceRequest(searchValue);
	}

	@Then("service request search should show {string}")
	public void assertSearchOutcome(String expectedOutcome) {
		serviceRequest.assertSearchOutcome(expectedOutcome);
	}

	@Then("service request list should remain stable after search")
	public void stableAfterSearch() {
		serviceRequest.assertListViewControlsVisible();
	}

	@Then("user should be able to clear service request search")
	public void clearSearch() {
		serviceRequest.clearSearch();
	}

	@Then("service request list should refresh to default results")
	public void refreshedDefault() {
		serviceRequest.assertListLoadedOrEmptyState();
	}

	@When("user opens service request filter panel")
	public void openFilterPanel() {
		serviceRequest.openFilterPanel();
	}

	@When("user applies service request filter {string} with value {string}")
	public void applySingleFilter(String filterType, String filterValue) {
		serviceRequest.applyFilter(filterType, filterValue);
	}

	@Then("service request results should be filtered by {string}")
	public void assertFilteredBy(String filterType) {
		serviceRequest.assertFilterApplied(filterType);
	}

	@Then("service request filter should be applied")
	public void assertFilterApplied() {
		serviceRequest.assertAnyFilterApplied();
	}

	@When("user sorts service request list by {string} in {string} order")
	public void sortList(String column, String direction) {
		serviceRequest.sortBy(column, direction);
	}

	@Then("service request list should be sorted by {string} in {string} order")
	public void assertSorted(String column, String direction) {
		serviceRequest.assertSorted(column, direction);
	}

	@Then("service request list should remain stable after sort")
	public void stableAfterSort() {
		serviceRequest.assertListViewControlsVisible();
	}

	@Then("service request results should satisfy applied filters")
	public void satisfyFilters() {
		serviceRequest.assertAnyFilterApplied();
		serviceRequest.assertListLoadedOrEmptyState();
	}

	@When("user clears all service request filters")
	public void clearAllFilters() {
		serviceRequest.clearAllFilters();
	}

	@Then("service request pagination controls should be visible")
	public void paginationVisible() {
		serviceRequest.assertPaginationControlsVisible();
	}

	@When("user navigates to next service request page")
	public void nextPage() {
		serviceRequest.goToNextPage();
	}

	@When("user navigates to previous service request page")
	public void prevPage() {
		serviceRequest.goToPreviousPage();
	}

	@Then("service request page number should change")
	public void pageNumberChanges() {
		serviceRequest.assertPageNumberChangedSinceLastNavigation();
	}

	@When("user opens first service request from list")
	public void openFirstFromList() {
		serviceRequest.openFirstServiceRequestFromList();
	}

	@Then("service request details view should be displayed")
	public void detailsViewDisplayed() {
		serviceRequest.assertDetailsViewDisplayed();
	}

	@Then("service request details should show SR number")
	public void detailsShowSrNumber() {
		serviceRequest.assertDetailsHasSrNumber();
	}

	@Then("service request details should show created date")
	public void detailsShowCreatedDate() {
		serviceRequest.assertDetailsHasCreatedDate();
	}

	@Then("service request details should show category and subcategory")
	public void detailsShowCategorySubcategory() {
		serviceRequest.assertDetailsHasCategoryAndSubcategory();
	}

	@When("user opens SR Details tab in detailed view")
	public void openSrDetailsTab() {
		serviceRequest.openSrDetailsTab();
	}

	@Then("SR Details section should be visible")
	public void srDetailsVisible() {
		serviceRequest.assertSrDetailsSectionVisible();
	}

	@When("user opens Approval List tab in detailed view")
	public void openApprovalListTab() {
		serviceRequest.openApprovalListTab();
	}

	@Then("Approval List section should be visible")
	public void approvalListVisible() {
		serviceRequest.assertApprovalListSectionVisible();
	}

	@When("user opens Attachments tab in detailed view")
	public void openAttachmentsTab() {
		serviceRequest.openAttachmentsTab();
	}

	@Then("Attachments section should be visible")
	public void attachmentsVisible() {
		serviceRequest.assertAttachmentsSectionVisible();
	}

	@Then("approval list should contain at least 1 approver entry")
	public void approverCount() {
		serviceRequest.assertApproverEntriesPresent();
	}

	@Then("each approver entry should show role name")
	public void approverRoleName() {
		serviceRequest.assertApproverRoleNamesPresent();
	}

	@Then("each approver entry should show approval status")
	public void approverStatus() {
		serviceRequest.assertApproverStatusesPresent();
	}

	@Then("approval list should remain visible")
	public void approvalRemainsVisible() {
		serviceRequest.assertApprovalListSectionVisible();
	}

	@When("user opens Messages section in detailed view")
	public void openMessages() {
		serviceRequest.openMessagesSection();
	}

	@When("user enters service request comment {string}")
	public void enterComment(String comment) {
		serviceRequest.enterComment(comment);
	}

	@When("user enters service request comment {string} for fitout handover") 
	public void enterCommentForFH(String comment) {
		serviceRequest.enterCommentForFH(comment);
	}

	@When("user submits service request comment")
	public void submitComment() {
		serviceRequest.submitComment();
	}

	@Then("comment should appear in message list")
	public void commentInList() {
		serviceRequest.assertLatestCommentVisible();
	}

	@Then("comment toast notification should be displayed")
	public void toastDisplayed() {
		serviceRequest.assertCommentToastDisplayed();
	}

	@When("user selects service request category {string} and subcategory {string}")
	public void selectCategoryAndSubcategory(String category, String subcategory) {
		serviceRequest.selectCategoryAndSubcategory(category, subcategory);
	}

	@When("user selects service request category {string}")
	public void selectCategoryOnly(String category) {
		serviceRequest.selectCategoryOnly(category);
	}

	@When("user leaves service request category unselected")
	public void leaveCategoryUnselected() {
		serviceRequest.clearCategorySelection();
	}

	@When("user leaves service request subcategory unselected")
	public void leaveSubcategoryUnselected() {
		serviceRequest.clearSubcategorySelection();
	}

	@When("user selects service request mall {string}")
	public void selectMall(String mall) {
		serviceRequest.selectMall(mall);
	}

	@When("user clicks initiate audit request button")
	public void clickInitiateAuditRequestButton() {
		serviceRequest.clickInitiateAuditRequestButton();
	}

	@When("User selects enter brand name as {string}")
	public void user_selects_enter_brand_name_as(String brandName) throws InterruptedException {
		serviceRequest.selectBrand(brandName);
	}

	@When("user enters fitout period in days as {string}")
	public void user_enters_fitout_period_in_days_as(String fitoutPeriod) {
    serviceRequest.enterFitoutPeriod(fitoutPeriod);
	}

	@When("user selects LOD status as {string}")
	public void user_selects_LOD_status_as(String lodStatus) {
    serviceRequest.selectLODStatus(lodStatus);
	}

	@When("user selects service request company {string}")
	public void selectCompany(String company) throws InterruptedException {
		serviceRequest.selectCompany(company);
	}

	@When("user selects tenant contact {string}")
	public void selectTenantContact(String contact) throws InterruptedException {
		serviceRequest.selectTenantContact(contact);
	}

	@When("user selects lease_brand mall {string}")
	public void selectLeaseBrandMall(String mall) throws InterruptedException {
		serviceRequest.selectLeaseBrandMall1(mall);
	}

	@When("user selects lease_brand mall {string} for fitout handover")
	public void selectLeaseBrandMallForFH(String mall) throws InterruptedException {
		serviceRequest.selectLeaseBrandMall1ForFH(mall);
	}

	@When("user enters Location as {string} for fitout handover")
	public void enterLocationForFH(String location) {
		serviceRequest.enterLocationForFH(location);
	}

	@When("User enters complaint summary as {string}")
public void user_enters_complaint_summary_as(String summary) {
    serviceRequest.enterComplaintSummary(summary);
}

	@When("user waits {string} seconds for dropdown options to load")
	public void waitForDropdownOptions(String seconds) {
		serviceRequest.waitForDropdownOptions(seconds);
	}

	@When("user leaves service request mall unselected")
	public void leaveMallUnselected() {
		serviceRequest.clearMallSelection();
	}

	@When("user enters service request subject {string}")
	public void enterSubject(String subject) {
		serviceRequest.enterSubject(subject);
	}
	
		

	@When("user enters service request description {string}")
	public void enterDescription(String description) {
		serviceRequest.enterDescription(description);
	}

	@When("user enters service request notes {string}")
	public void enterNotes(String notes) throws InterruptedException {
		serviceRequest.enterNotes(notes);
	}

	@When("user enters service request description with more than 2000 characters")
	public void enterDescriptionTooLong() {
		serviceRequest.enterDescriptionMoreThan2000Chars();
	}

	@Then("service request subject value should be {string}")
	public void assertSubjectValue(String expected) {
		serviceRequest.assertSubjectValue(expected);
	}

	@Then("service request description value should be {string}")
	public void assertDescriptionValue(String expected) {
		serviceRequest.assertDescriptionValue(expected);
	}

	@When("user enters contractor mobile number as {string}")
	public void enterContractorMobile(String mobile) {
		serviceRequest.enterContractorMobileNumber(mobile);
	}

	@Then("contractor mobile number validation message should be displayed")
	public void contractorMobileValidation() {
		serviceRequest.assertContractorMobileValidationVisible();
	}

	@When("user uploads service request attachment {string}")
	public void uploadAttachmentByName(String fileName) throws InterruptedException {
		serviceRequest.uploadAttachmentByDisplayedName(fileName);
	}

	@Then("uploaded attachment file name should be displayed as {string}")
	public void assertUploadedFileName(String expectedFileName) {
		serviceRequest.assertUploadedAttachmentFileName(expectedFileName);
	}

	@When("user uploads service request attachments:")
	public void uploadAttachments(DataTable dataTable) throws InterruptedException {
		serviceRequest.uploadAttachments(dataTable);
	}

	@When("user uploads a large service request attachment {string} of size {string} KB")
	public void uploadLargeAttachment(String fileName, String sizeKb) throws InterruptedException {
		serviceRequest.uploadLargeAttachment(fileName, sizeKb);
	}

	@When("user removes uploaded attachment {string}")
	public void removeUploadedAttachment(String fileName) {
		serviceRequest.removeUploadedAttachment(fileName);
	}

	@Then("uploaded attachment file name should contain {string}")
	public void uploadedAttachmentShouldContain(String expectedFileName) {
		serviceRequest.assertUploadedAttachmentContains(expectedFileName);
	}

	@Then("uploaded attachment file name should not contain {string}")
	public void uploadedAttachmentShouldNotContain(String fileName) {
		serviceRequest.assertUploadedAttachmentNotContains(fileName);
	}

	@When("user enters service request title {string}")
	public void enterServiceRequestTitle(String title) {
    serviceRequest.enterServiceRequestTitle(title);
}

@When("user selects unit code {string}")
public void selectUnitCode(String unitCode) {
    serviceRequest.selectUnitCode(unitCode);
}

@When("user selects unit type {string}")
public void selectUnitType(String unitType) {
    serviceRequest.selectUnitType(unitType);
	
}

@When("user contractor name {string}")
public void enterContractorName(String name) {
    serviceRequest.enterContractorName(name);
}

@When("user enters contractor mobile number {string}")
public void enterContractorMobiles(String mobile) {
    serviceRequest.enterContractorMobileNumber(mobile);
}

@When("user enters type of work as {string}")
public void enterTypeOfWork(String workType) {
    serviceRequest.enterTypeOfWork(workType);
}

@When("user enters Location as {string}")
public void enterLocation(String location) {
    serviceRequest.enterLocation(location);
}

@When("user clicks performer section collapse dropdown")
public void clickPerformerSection() {
    serviceRequest.openPerformerSection();
}

@When("user enters performer name as {string}")
public void enterPerformerName(String name) {
    serviceRequest.enterPerformerName(name);
}

@When("user enters performer designation as {string}")
public void enterPerformerDesignation(String designation) {
    serviceRequest.enterPerformerDesignation(designation);
}

@When("user enters performer personal qualification as {string}")
public void enterQualification(String qualification) {
    serviceRequest.enterPerformerQualification(qualification);
}

@When("user enters mobile number as {string}")
public void enterPerformerMobile(String mobile) {
    serviceRequest.enterPerformerMobile(mobile);
}

@When("user enters iqama number as {string}")
public void enterIqama(String iqama) {
    serviceRequest.enterIqamaNumber(iqama);
}

@When("user enters instructors full name as {string}")
public void enterInstructorName(String name) {
    serviceRequest.enterInstructorName(name);
}

@When("user enters planned date and time collapse dropdown")
public void openPlannedDateSection() {
    serviceRequest.openPlannedDateSection();
}

@When("user picks from date {string} and To date {string}")
public void selectDates(String start, String end) throws InterruptedException {
    serviceRequest.selectFromToDate(start, end);
}

@When("user picks from date {string} and end date {string}")
public void selectStartAndEndDate(String start, String end) throws InterruptedException {
    serviceRequest.selectStartEndDate(start, end);
}

@When("user picks first period from time {string} and to time {string}")
public void selectFirstPeriod(String from, String to) {
    serviceRequest.selectFirstPeriod(from, to);
}

@When("user picks second period from time {string} and to time {string}")
public void selectSecondPeriod(String from, String to) {
    serviceRequest.selectSecondPeriod(from, to);
}

@When("user selects {string} for {string}")
    public void user_selects_option(String value, String question) {
        serviceRequest.selectMeasureOption(question, value);
}

@When("user click measures of safety collapse dropdown")
public void openSafetySection() {
    serviceRequest.openSafetySection();
}

@When("user selects all measures of safety")
public void selectAllSafetyMeasures() {
    serviceRequest.selectAllSafetyMeasures();
}

@When("user enters Demanded appendices as {string}")
public void enterAppendices(String value) {
    serviceRequest.enterAppendices(value);
}

@When("user enters Special Conditions as {string}")
public void enterSpecialConditions(String value) {
    serviceRequest.enterSpecialConditions(value);
}

@When("user submits work permit service request form")
public void submitWorkPermitForm() throws InterruptedException {
    serviceRequest.submitRequestForm();
}

@When("user enters event details as {string}")
public void user_enters_event_details(String event) {
    serviceRequest.enterEventDetails(event);
}

@When("user selects Violation Issuance Date as {string}")
public void user_selects_violation_issuance_date(String date) {
    serviceRequest.selectViolationIssuanceDate(date);
}

@When("user selects audit report Date as {string}")
public void user_selects_audit_report_date(String date) {
    serviceRequest.selectAuditReportDate(date);
}

@When("user enters location of occurance as {string}")
public void user_enters_location_of_occurance(String location) {
    serviceRequest.enterLocationOfOccurance(location);
}

@When("user selects date of occurance as {string}")
public void user_selects_date_of_occurance(String date) {
    serviceRequest.selectDateOfOccurrence(date);
}

@When("user selects time of occurance as {string}")
public void user_selects_time_of_occurance(String time) {
    serviceRequest.selectTimeOfOccurrence(time);
}

@When("user selects incident type as {string}")
public void user_selects_incident_type(String type) {
    serviceRequest.selectIncidentType(type);
}

@When("user enters unit number as {string}")
public void user_enters_unit_number(String unit) {
    serviceRequest.enterUnitNumber(unit);
}

@When("user enters inspector name as {string}")
public void user_enters_inspector_name(String name) {
    serviceRequest.enterInspectorName(name);
}

@When("user selects Date of First Notification as {string}")
public void user_selects_first_notification_date(String date) {
    serviceRequest.selectFirstNotificationDate(date);
}

@When("user selcts violation category as {string}")
public void user_selects_violation_category(String category) {
    serviceRequest.selectViolationCategory(category);
}

@When("user selects notice level as {string}")
public void user_selects_notice_level(String level) {
    serviceRequest.selectNoticeLevel(level);
}

@When("user selects violation scope as {string}")
public void user_selects_violation_scope(String scope) {
    serviceRequest.selectViolationScope(scope);
}

@When("user selects notice number as {string}")
public void user_selects_notice_number(String number) {
    serviceRequest.selectNoticeNumber(number);
}

@When("user enters violation description as {string}")
public void user_enters_violation_description(String desc) {
    serviceRequest.enterViolationDescription(desc);
}

@When("user enters who exposed to hazards as {string}")
public void user_enters_exposed_to_hazards(String value) {
    serviceRequest.enterExposedToHazards(value);
}

@When("user enters possible consequences as {string}")
public void user_enters_possible_consequences(String value) {
    serviceRequest.enterPossibleConsequences(value);
}

@When("user enters root cause as {string}")
public void user_enters_root_cause(String value) {
    serviceRequest.enterRootCause(value);
}

@When("user enters required actions as {string}")
public void user_enters_required_actions(String value) {
    serviceRequest.enterRequiredActions(value);
}

@When("user enters comments as {string}")
public void user_enters_comments(String value) {
    serviceRequest.enterComments(value);
}

@When("user clicks save button")
public void clickSaveButton() {
    serviceRequest.clickSaveButton();
}

}