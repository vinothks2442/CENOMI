package com.automation.web.NG_Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.web.Report_Utils.ReportManager;
import com.automation.web.common_utils.BrowserFactory;
import com.automation.web.common_utils.VideoRecord;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class PageEvent implements ITestListener {

    public static String strBrowser;
    private static final String SYS_CLOSE_BROWSER_ON_FAILURE = "closeBrowserOnFailure";
    private static final String SYS_CLOSE_BROWSER_ON_PASS = "closeBrowserOnPass";

    private boolean shouldCloseBrowser(boolean isFailure) {
        if (isFailure) {
            return Boolean.parseBoolean(System.getProperty(SYS_CLOSE_BROWSER_ON_FAILURE, "false"));
        }
        return Boolean.parseBoolean(System.getProperty(SYS_CLOSE_BROWSER_ON_PASS, "true"));
    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("+++++++++++++++++++++onTestStart++++++++++++++++++++");

        // ✅ START EXTENT TEST
        ReportManager.startTest(result.getMethod().getMethodName(), "WEB");

        strBrowser = System.getProperty("Browser", "chromium");

        System.out.println("Execution started @ " + strBrowser + " browser & for type : Web UI");

        try {

            VideoRecord.startRecord(result.getMethod().getMethodName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        try {

            if (shouldCloseBrowser(false)) {
                BrowserFactory.getInstance().closeBrowser();
            }

            VideoRecord.stopRecord();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("+++++++++++++++++++++onTestFailure++++++++++++++++++++");

        if (ReportManager.getCurrentTest() != null) {

            ReportManager.logFail(result.getThrowable().toString());

            try {

                ReportManager.logScreenshot();

            } catch (IOException e) {
                e.printStackTrace();
            }

            ReportManager.endCurrentTest();
        }

        try {

            VideoRecord.stopRecord();

            if (shouldCloseBrowser(true)) {
                BrowserFactory.getInstance().closeBrowser();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        String logText = "<b>" + result.getMethod().getMethodName() + " is skipped.</b>";

        MarkupHelper.createLabel(logText, ExtentColor.YELLOW);

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
}