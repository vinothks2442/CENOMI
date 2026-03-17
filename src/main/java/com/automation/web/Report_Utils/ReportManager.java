package com.automation.web.Report_Utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.automation.web.common_utils.Constants;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    public static ExtentReports extent;
    public static Map<Long, ExtentTest> testMap = new HashMap<>();
    public static Map<String, ExtentTest> extentMap = new HashMap<>();

    public static void startReport() {

        if (Objects.isNull(extent)) {

            extent = new ExtentReports();

            String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());

            ExtentSparkReporter spark = new ExtentSparkReporter(Constants.extent_reportPath);

            extent.attachReporter(spark);

            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Project");
            spark.config().setReportName("Project");

            extent.setSystemInfo("Organization", "DEMO");
            extent.setSystemInfo("Employee",
                    "<b> Test User1</b> " +
                            Constants.ICON_SOCIAL_LINKEDIN + " " +
                            Constants.ICON_SOCIAL_GITHUB);

            extent.setSystemInfo("Domain",
                    "Engineering (IT - Software) " + Constants.ICON_LAPTOP);

            extent.setSystemInfo("Skill", "Test Automation Engineer");
        }
    }

    public static void startTest(String testName, String categories) {

        ExtentTest test = extent.createTest(testName);
        test.assignCategory(categories);

        testMap.put(Thread.currentThread().getId(), test);
        extentMap.put(testName, test);
    }

    public static void logScreenshot() throws IOException {

        ExtentTest test = getCurrentTest();

        if (test != null) {

            String screenshot = Screenshot_Util.takeScreenshot();

            test.addScreenCaptureFromBase64String(screenshot);

            Media mediaModel = MediaEntityBuilder
                    .createScreenCaptureFromBase64String(screenshot)
                    .build();

            test.fail("", mediaModel);
        }
    }

    public static void logPass(String message) {

        ExtentTest test = getCurrentTest();

        if (test != null) {
            test.log(Status.PASS, message);
        }
    }

    public static void logFail(String message) {

        ExtentTest test = getCurrentTest();

        if (test != null) {
            test.log(Status.FAIL, message);
        }
    }

    public static void logInfo(String message) {

        ExtentTest test = getCurrentTest();

        if (test != null) {
            test.log(Status.INFO, message);
        }
    }

    public static void endCurrentTest() {

        testMap.remove(Thread.currentThread().getId());
    }

    public static ExtentTest getCurrentTest() {

        return testMap.get(Thread.currentThread().getId());
    }

    public static void endReport() {

        if (extent != null) {
            extent.flush();
        }
    }
}