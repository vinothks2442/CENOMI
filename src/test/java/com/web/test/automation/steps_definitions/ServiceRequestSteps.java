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
	public void submitCreateForm() {
		serviceRequest.submitRequestForm();
	}

	@When("user submits service request form with extended wait time")
	public void submitCreateFormExtendedWait() {
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

}