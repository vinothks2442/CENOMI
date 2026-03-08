package com.automation.web.ccl;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.automation.web.Report_Utils.ReportManager;
import com.automation.web.common_utils.BrowserFactory;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import junit.framework.Assert;

public class PlayActions {
	private  BrowserContext context = BrowserFactory.getInstance().getBrowserContext();

	private Page page = BrowserFactory.getInstance().getPage();

	public void navigate(String URL) {
		page.navigate(URL);
		String ActualURL = page.url();
		System.out.println("Actual URL - " + ActualURL);
		System.out.println("Expected URL - " + URL);
		ReportManager.logInfo("Actual URL - " + ActualURL);
		ReportManager.logInfo("Expected URL - " + URL);
	}
	

	public void click(String locator, String info) {
		page.click(locator);
		System.out.println("Successfully clicked on  -  " + info);
		ReportManager.logInfo("Successfully clicked on  -  " + info);
	}

	public void fill(String locator, String value, String info) {
		page.fill(locator, value);
		System.out.println("Successfully entered value -  " + value + " in " + info + " box");
		ReportManager.logInfo("Successfully entered value -  " + value + " in " + info + " box");
	}

	public void type(String locator, String value, String info) {
		page.type(locator, value);
		System.out.println("Successfully entered value -  " + value + " in " + info + " box");
		ReportManager.logInfo("Successfully entered value -  " + value + " in " + info + " box");
	}

	public void clickInsideFrame(String frameLocator, String elementLocator, String info) {
		Locator locator = page.frameLocator(frameLocator).locator(elementLocator);
		locator.click();
		System.out.println("Successfully clicked on  -  " + info);
		ReportManager.logInfo("Successfully clicked on  -  " + info);
	}

	/**
	 * In Playwright, there's no need to explicitly use a method to switch back from
	 * a frame to the default content. The platform automatically handles the
	 * content switching, excluding nested frames. This automatic switching applies
	 * specifically to methods such as clickInsideFrame, isVisibleInsideFrame,
	 * getTextInsideFrame, and sendKeysInsideFrame. <br>
	 * 
	 * @param frameLocator
	 * @param elementLocator
	 * @param info
	 * @return boolean
	 */
	public int allTextContentsSelectDrpdwnCount(String selectorDrpDwn) {
		Locator selectElement = page.locator(selectorDrpDwn); // Example using ID
        int optionCount = selectElement.locator("option").count();
        System.out.println("Number of options: " + optionCount);
        return optionCount;
	}
	
	public List allTextContentsSelectDrpdwn(String selectorDrpDwn) {
		Locator selectElement = page.locator(selectorDrpDwn); // Example using I
        // Get the labels of each option
        List<String> optionLabels = selectElement.locator("option").allInnerTexts();
        System.out.println("Option labels: " + optionLabels);
        return optionLabels;
	}
	
	public boolean isVisibleInsideFrame(String frameLocator, String elementLocator, String info) {
		Locator locator = page.frameLocator(frameLocator).locator(elementLocator);
		boolean isPresent = locator.isVisible();
		if (isPresent == true) {
			System.out.println("Successfully element is displayed  -  " + info);
			ReportManager.logInfo("Successfully element is displayed  -  " + info);
		} else {
			ReportManager.logInfo("element not displayed: " + info);
			System.out.println("element not displayed: " + info);

		}
		return isPresent;
	}

	public String getTextInsideFrame(String frameLocator, String elementLocator, String info) {
		Locator locator = page.frameLocator(frameLocator).locator(elementLocator);
		String text = locator.textContent();
		System.out.println("Text is -  " + text);
		ReportManager.logInfo("Text is -  " + text);
		return text;
	}

	public void fillInsideFrame(String frameLocator, String elementLocator, String value, String info) {
		Locator locator = page.frameLocator(frameLocator).locator(elementLocator);
		locator.fill(value);
		System.out.println("Successfully entered value -  " + value + " in " + info + " box");
		ReportManager.logInfo("Successfully entered value -  " + value + " in " + info + " box");
	}

	public void typeInsideFrame(String frameLocator, String elementLocator, String value, String info) {
		Locator locator = page.frameLocator(frameLocator).locator(elementLocator);
		locator.type(value);
		System.out.println("Successfully entered value -  " + value + " in " + info + " box");
		ReportManager.logInfo("Successfully entered value -  " + value + " in " + info + " box");
	}

	Frame frame;

	/**
	 * This method returns a Frame, and here's how you can utilize it:
	 * 
	 * <p>
	 * **Usage**
	 *
	 * <pre>{@code
	 * Locator locator = play.switchToFrame(frameLocator, info).locator(elementInsideFrame); 
	 * import Locator from com.microsoft.playwright package; 
	 * locator.click(); // This will click on an element inside a frame.
	 * }</pre>
	 * 
	 * <pre>{@code
	 * List<Frame> childFrames = play.switchToFrame(frameLocator, info).childFrames();
	 * Frame secondChildFrame = childFrames.get(1);
	 * secondChildFrame.locator(elemtInsideSecondFrame).click(); // Click on an element inside the second childFrame.
	 * }</pre>
	 * 
	 * <pre>
	 * {@code // If you need to switch back to the parent frame, use this:
	 * Frame parentFrame = secondChildFrame.parentFrame();
	 * Using the parentFrame reference, you can enhance your automation in nested frames.
	   }</pre>
	 * 
	 * <p>
	 * These examples illustrate how to use the provided method for handling frames
	 * in a nested structure using Playwright.
	 * 
	 * @param frameLocator
	 * @param info
	 * @return
	 */
	public Frame switchToFrame(String frameLocator, String info) {
		frame = page.frame(frameLocator);
		ReportManager.logInfo("Successfully switched to frame -  " + info);
		System.out.println("Successfully switched to frame -  " + info);
		return frame;
	}

	public void switchToDefaultPage(String info) {
		page = frame.page();
		ReportManager.logInfo("Successfully switched to default page -  " + info);
		System.out.println("Successfully switched to default page -  " + info);
	}

	public String textContent(String locator) {
		String Text = page.textContent(locator);
		System.out.println("Text is -  " + Text);
		ReportManager.logInfo("Text is -  " + Text);
		return Text;
	}

	public void draganddrop(String source, String target) {
		page.dragAndDrop(source, target);
		System.out.println("Successfully dragged from " + source + " to " + target);
		ReportManager.logInfo("Successfully dragged from " + source + " to " + target);
	}

	public void check(String locator, String info) {
		page.check(locator);
		System.out.println("Successfully checked -  " + locator + " in " + info + " box");
		ReportManager.logInfo("Successfully checked -  " + locator + " in " + info + " box");

	}

	public String getContent() {
		String content = page.content();
		System.out.println("The HTML page content is " + content);
		ReportManager.logInfo("The HTML page content is " + content);
		return content;
	}

	public void verifyText(String actualText, String expectedText) {
		ReportManager.logInfo("Actual Text - " + actualText);
		ReportManager.logInfo("Expected Text - " + expectedText);
		System.out.println("Actual Text - " + actualText);
		System.out.println("Expected Text - " + expectedText);
		assertEquals(actualText, expectedText);
	}

	public void verifyIntValues(int actualValue, int expectedValue) {
		ReportManager.logInfo("Actual Value - " + actualValue);
		ReportManager.logInfo("Expected Value - " + expectedValue);
		System.out.println("Actual Value - " + actualValue);
		System.out.println("Expected Value - " + expectedValue);
		assertEquals(actualValue, expectedValue);
	}

	public String getAttributeValue(String locator, String name) {

		String attributeText = page.getAttribute(locator, name);
		ReportManager.logInfo("Successfully get attribute text - " + attributeText);
		System.out.println("Successfully get attribute text - " + attributeText);
		return attributeText;
	}
	
	public void isClickable(String Elelocator, String info) {
		Locator locator = page.locator(Elelocator);

        // Check if the element is visible and enabled
        boolean isVisible = locator.isVisible();
        boolean isEnabled = locator.isEnabled();
        boolean isClickable = isVisible && isEnabled;

        if (isClickable) {
            System.out.println("The element is clickable.");
        } else {
            Assert.assertEquals(true, false);
        }
        ReportManager.logInfo("The element is clickable  -  " + info);
	}
	
	
	public void doubleClick(String locator, String info) {
		page.dblclick(locator);
		System.out.println("Successfully double clicked on  -  " + info);
		ReportManager.logInfo("Successfully double clicked on  -  " + info);
	}

	public void backButton(String locator, String info) {
		page.goBack();
		System.out.println("Successfully clicked on Back Button");
		ReportManager.logInfo("Successfully clicked on Back Button");
	}

	public void nextPage(String locator, String info) {
		page.goForward();
		System.out.println("Successfully clicked on Forward Button");
		ReportManager.logInfo("Successfully clicked on Forward Button");
	}

	public void mouseHover(String locator, String info) {
		page.hover(locator);
		System.out.println("Successfully mouse hoverd on  -  " + info);
		ReportManager.logInfo("Successfully mouse hoverd on  -  " + info);
	}

	public boolean isChecked(String locator, String info) {

		boolean isChecked = page.isChecked(locator);
		if (isChecked == true) {
			System.out.println("Successfully element is checked  -  " + info);
			ReportManager.logInfo("Successfully element is checked  -  " + info);
		} else {
			ReportManager.logInfo("element not checked: " + info);
			System.out.println("element not is checked: " + info);

		}
		return isChecked;
	}

	public boolean isDisabled(String locator, String info) {

		boolean isDisabled = page.isDisabled(locator);
		if (isDisabled == true) {
			System.out.println("Successfully element is disabled  -  " + info);
			ReportManager.logInfo("Successfully element is disabled  -  " + info);
		} else {
			ReportManager.logInfo("element not disabled: " + info);
			System.out.println("element not is disabled: " + info);

		}
		return isDisabled;
	}

	public boolean isEnabled(String locator, String info) {

		boolean isEnabled = page.isEnabled(locator);
		if (isEnabled == true) {
			System.out.println("Successfully element is enabled  -  " + info);
			ReportManager.logInfo("Successfully element is enabled  -  " + info);
		} else {
			ReportManager.logInfo("element not enabled: " + info);
			System.out.println("element not is enabled: " + info);

		}
		return isEnabled;
	}

	public boolean isVisible(String locator, String info) {
		boolean isPresent = page.isVisible(locator);
		if (isPresent == true) {
			System.out.println("Successfully element is displayed  -  " + info);
			ReportManager.logInfo("Successfully element is displayed  -  " + info);
		} else {
			ReportManager.logInfo("element not displayed: " + info);
			System.out.println("element not displayed: " + info);

		}
		return isPresent;
	}

	public String getTitle() {
		String title = page.title();
		System.out.println("The title of the page is : " + title);
		ReportManager.logInfo("The title of the page is : " + title);
		return title;
	}

	public void uncheck(String locator, String info) {
		page.uncheck(locator);
		System.out.println("Successfully element is uncheck  -  " + info);
		ReportManager.logInfo("Successfully element is uncheck  -  " + info);
	}

	public boolean isDisplayed(String locator, String info) {
		boolean isPresent = page.isVisible(locator);

		if (isPresent == true) {
			ReportManager.logInfo("Successfully element displayed: " + info);
			System.out.println("Successfully element displayed: " + info);
		} else {
			ReportManager.logInfo("element not displayed: " + info);
			System.out.println("element not displayed: " + info);

		}
		return isPresent;
	}

	public void scrollToElement(String locator, String info) {
		page.locator(locator).scrollIntoViewIfNeeded();
		ReportManager.logInfo("Successfully scrolled to - " + info);
		System.out.println("Successfully scrolled to - " + info);
	}

	public void keyboard(String keys) {
		/**
		 * refer this link -> https://playwright.dev/java/docs/api/class-keyboard
		 **/
		Keyboard key = page.keyboard();
		key.press(keys);
		System.out.println("Successfully clicked on  -  " + keys);
		ReportManager.logInfo("Successfully clicked on  -  " + keys);
	}

	public void delayClick(String locator, double setDelayInMilliSec, String info) {
		page.click(locator, new Page.ClickOptions().setDelay(setDelayInMilliSec));
		System.out.println("Successfully clicked on  -  " + info);
		ReportManager.logInfo("Successfully clicked on  -  " + info);
	}

	public void waitForUpload(String locator, String path, String info) {
		page.setInputFiles(locator, Paths.get(path));
		System.out.println("Successfully file uploaded -  " + info);
		ReportManager.logInfo("Successfully file uploaded  -  " + info);
	}
	
	public String inputValue(String locator){
		Locator input = page.locator(locator);
        String inputValue = input.inputValue();
        return inputValue;
		
	}

	public void waitForDownload(String locator, String path) {
		Download download = page.waitForDownload(() -> {
			page.click(locator);
		});
		String fileName = download.suggestedFilename();
		download.saveAs(Paths.get(path + fileName));
		System.out.println("Successfully file downloaded -  " + fileName);
		System.out.println("File path - " + path + fileName);
		ReportManager.logInfo("Successfully file downloaded  -  " + fileName);
	}

	public void SelectOptions(String locator, String index) {
		page.selectOption(locator, index);
		System.out.println("Successfully selected the value in Dropdown");
		ReportManager.logInfo("Successfully selected the value in Dropdown");

	}

	public void clear(String locator, String text) {

		page.locator(locator).click();
		page.keyboard().press("Control+A");
		page.keyboard().down("Delete");
		ReportManager.logInfo("Successfully Cleared text - " + text);
		System.out.println("Successfully Cleared text - " + text);

	}

	public Page getPage() {
		return page;
	}
	
	public  BrowserContext getContext() {
		return context;
	}

	public boolean waitForVisible(String locator, double setTimeoutInMilliSec, String info) {
		// boolean isPresent = page.isVisible(locator, new
		// Page.IsVisibleOptions().setTimeout(setTimeoutInMilliSec)); --> this statement
		// got deprecated so,
		ElementHandle element = page.waitForSelector(locator, new Page.WaitForSelectorOptions()
				.setState(WaitForSelectorState.VISIBLE).setTimeout(setTimeoutInMilliSec));
		boolean isPresent = element.isVisible();
		if (isPresent == true) {
			System.out.println("Successfully element is displayed  -  " + info);
			ReportManager.logInfo("Successfully element is displayed  -  " + info);
		} else {
			ReportManager.logInfo("element not displayed: " + info);
			System.out.println("element not displayed: " + info);

		}
		return isPresent;
	}

	public void waitForClick(String locator, double setTimeoutInMilliSec, String info) {
		page.click(locator, new Page.ClickOptions().setTimeout(setTimeoutInMilliSec));
		System.out.println("Successfully clicked on  -  " + info);
		ReportManager.logInfo("Successfully clicked on  -  " + info);
	}

	public void waitForOpenURL(String URL, double setTimeoutInMilliSec) {
		page.navigate(URL, new Page.NavigateOptions().setTimeout(setTimeoutInMilliSec));
		String ActualURL = page.url();
		System.out.println("Actual URL - " + ActualURL);
		System.out.println("Expected URL - " + URL);
		ReportManager.logInfo("Actual URL - " + ActualURL);
		ReportManager.logInfo("Expected URL - " + URL);
	}

	public void retrieveExcelData() throws IOException, EncryptedDocumentException, InvalidFormatException {
		FileInputStream fileinputstream = new FileInputStream("./Excel_File/SwagLabs_With_Sample.xlsx");
		// FileInputStream fileinputstream = new
		// FileInputStream("F:\\Ecubix\\PlaywrightWeb\\Ecubix_With_Sample.xlsx");
		Workbook workbook = WorkbookFactory.create(fileinputstream);
		String date = workbook.getSheet("SwagLabs").getRow(1).getCell(8).getStringCellValue();
		String doctorcode = workbook.getSheet("SwagLabs").getRow(1).getCell(9).getStringCellValue();
		String doctorname = workbook.getSheet("SwagLabs").getRow(1).getCell(10).getStringCellValue();
		String sample = workbook.getSheet("SwagLabs").getRow(1).getCell(24).getStringCellValue();
		String samplequantity = workbook.getSheet("SwagLabs").getRow(1).getCell(25).getStringCellValue();
		System.out.println("TodayDate  -" + date);
		ReportManager.logInfo("Successfully retrieved the Date  -  " + date);
		System.out.println("DoctorCode  -" + doctorcode);
		ReportManager.logInfo("Successfully retrieved the DoctorCode  -  " + doctorcode);
		System.out.println("DoctorName  -" + doctorname);
		ReportManager.logInfo("Successfully retrieved the DoctorName  -  " + doctorname);
		System.out.println("Sample  -" + sample);
		ReportManager.logInfo("Successfully retrieved the Sample  -  " + sample);
		System.out.println("SampleQuantity -" + samplequantity);
		ReportManager.logInfo("Successfully retrieved the SampleQuantity  -  " + samplequantity);

	}

}
