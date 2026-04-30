package com.automation.web.NG_Listeners;

import java.lang.reflect.Constructor;

import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.automation.web.common_utils.ConfigReader;
import com.automation.web.Report_Utils.ReportManager;

public class TestNGRetry implements IRetryAnalyzer, IAnnotationTransformer {

	private int retryCnt = 0;

// You can mention maxRetryCnt (Maximium Retry Count) as per your requirement.
// This example uses 2 which means that for any failed testcases it retires the
// run twice.

	private int maxRetryCnt = ConfigReader.getIntValue("reTry");

// This method will be called everytime a test fails. It will return TRUE if a
// test fails and need to be retried, else it returns FALSE

	public boolean retry(ITestResult result) {

		if (retryCnt < maxRetryCnt) {
			System.out.println("Test Fail: " + result.getMethod().getMethodName());
			ReportManager.logFail("Test case Fail");
			ReportManager.logInfo(result.getThrowable().getMessage());

			try {
				// ReportManager.logMobileScreenshot();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ReportManager.endCurrentTest();
			System.out.println("Retrying " + result.getName() + " again and the count is " + (retryCnt + 1));

			retryCnt++;

			return true;

		}

		return false;

	}

	@Override
	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
//IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

		testannotation.setRetryAnalyzer(TestNGRetry.class);

	}

}