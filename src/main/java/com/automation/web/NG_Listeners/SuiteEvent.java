package com.automation.web.NG_Listeners;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.testng.IExecutionListener;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

import com.automation.web.Report_Utils.ReportManager;
import com.automation.web.common_utils.BrowserFactory;
import com.opencsv.CSVWriter;

public class SuiteEvent extends TestListenerAdapter
        implements ISuiteListener, IExecutionListener, IReporter {

    CSVWriter writer;
    public List<String[]> data = new ArrayList<>();

    public static String str_Execution_TYPE;
    public static String str_browser;
    public static String str_platform;

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Suite started: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Suite finished: " + suite.getName());
    }

    // Runs before execution starts
    @Override
    public void onExecutionStart() {

        System.out.println("In on execution start");

        str_Execution_TYPE = System.getProperty("execType", "Web_UI");

        System.out.println("Execution type is: " + str_Execution_TYPE);

        if (str_Execution_TYPE.equalsIgnoreCase("Web_UI")) {

            // Start Extent Report
            ReportManager.startReport();

        } else {
            System.out.println("[-] Please set execution type [Web_UI] in VM arguments");
        }
    }

    // Runs after execution finishes
    @Override
    public void onExecutionFinish() {

        str_browser = System.getProperty("Browser", "chromium");
        str_platform = System.getProperty("os.name");

        if (str_Execution_TYPE.equalsIgnoreCase("Web_UI")) {

            try {

                if (ReportManager.extent != null) {

                    String browserVersion = "unknown";
                    if (BrowserFactory.getInstance().getBrowserContext() != null
                            && BrowserFactory.getInstance().getBrowserContext().browser() != null) {
                        browserVersion = BrowserFactory.getInstance().getBrowserContext().browser().version();
                    }

                    ReportManager.extent.setSystemInfo(
                            "Browser",
                            str_browser + " v" + browserVersion);

                    ReportManager.extent.setSystemInfo(
                            "Platform",
                            str_platform);

                    ReportManager.endReport();
                }

            } catch (Exception e) {

                System.out.println("Error finishing report");
                e.printStackTrace();
            }

        } else {
            System.out.println("[-] Please set execution type [Web_UI]");
        }
    }

    // Generate CSV test result report
    @Override
    public void generateReport(List<XmlSuite> xmlSuites,
                               List<ISuite> suites,
                               String outputDirectory) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String csv = "./test-results.csv";

        try {
            writer = new CSVWriter(new FileWriter(csv));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (ISuite suite : suites) {

            Map<String, ISuiteResult> results = suite.getResults();

            for (ISuiteResult result : results.values()) {

                ITestContext context = result.getTestContext();

                // FAILED TESTS
                IResultMap failedTests = context.getFailedTests();

                for (ITestNGMethod method : failedTests.getAllMethods()) {

                    Date dateTime = new Date(method.getDate());
                    String dateString = dateFormat.format(dateTime);

                    String[] dateParts = dateString.split(" ");

                    data.add(new String[]{
                            dateParts[0],
                            dateParts[1],
                            method.getMethodName(),
                            method.getDescription(),
                            "FAIL"
                    });
                }

                // PASSED TESTS
                IResultMap passedTests = context.getPassedTests();

                for (ITestNGMethod method : passedTests.getAllMethods()) {

                    Date dateTime = new Date(method.getDate());
                    String dateString = dateFormat.format(dateTime);

                    String[] dateParts = dateString.split(" ");

                    data.add(new String[]{
                            dateParts[0],
                            dateParts[1],
                            method.getMethodName(),
                            method.getDescription(),
                            "PASS"
                    });
                }
            }
        }

        String[] header = {"Date", "Time", "Test Case ID", "Description", "Result"};

        writer.writeNext(header);
        writer.writeAll(data);

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}