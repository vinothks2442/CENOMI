package com.automation.web.NG_Listeners;

import java.io.IOException;
import java.nio.file.Paths;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.web.Report_Utils.ReportManager;
import com.automation.web.common_utils.BrowserFactory;
import com.automation.web.common_utils.VideoRecord;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Tracing;

public class PageEvent implements ITestListener {
	
	public static String strBrowser;

	// RetryFailedTests retry = new RetryFailedTests();
	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("+++++++++++++++++++++onTestStart++++++++++++++++++++");
		// ReportManager.startTest(arg0.getMethod().getMethodName(),"WEB");
		strBrowser = System.getProperty("Browser");
		System.out.println("Execution started @ " + strBrowser + " browser & for type : Web UI");
		try {

			// initDriver.startWebDriver();
			VideoRecord.startRecord(arg0.getMethod().getMethodName());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		// driverFactory.getWebDriver().quit();

		try {
			BrowserFactory.getInstance().getPlaywright().close();
			VideoRecord.stopRecord();
			// initDriver.tearDownWebDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		try {
////			 Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
////			Runtime.getRuntime().exec("taskkill /f /im chrome.exe");
////			 Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
////			Runtime.getRuntime().exec("taskkill /f /im geckodriver.exe");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {

		// retry.retry(iTestResult);
		System.out.println("+++++++++++++++++++++onTestFailure++++++++++++++++++++");
		ReportManager.logFail(iTestResult.getThrowable().toString());

		try {
			ReportManager.logScreenshot();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReportManager.endCurrentTest();
		// driverFactory.getWebDriver().close();

		try {

			VideoRecord.stopRecord();
			BrowserFactory.getInstance().getPlaywright().close();

			// initDriver.tearDownWebDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * try { Runtime.getRuntime().exec("taskkill /f /im chrome.exe");
		 * Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
		 * Runtime.getRuntime().exec("taskkill /f /im geckodriver.exe"); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

		// ExtentLogger.skip("<b><i>" + result.getThrowable().toString() + "</i></b>");
		String logText = "<b>" + arg0.getMethod().getMethodName() + " is skipped.</b>";
		Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);

	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {

		// strBrowser = arg0.getCurrentXmlTest().getParameter("browser");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}
}
