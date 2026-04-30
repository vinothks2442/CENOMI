package com.web.test.automation.hooks;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.automation.web.Report_Utils.ReportManager;
import com.automation.web.Report_Utils.Screenshot_Util;
import com.automation.web.common_utils.BrowserFactory;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {

    public static ArrayList<String> passedTests = new ArrayList<>();
    public static ArrayList<String> failedTests = new ArrayList<>();
    public static ArrayList<String> totalTestCases = new ArrayList<>();

    private static String str_Execution_TYPE = "Web_UI";
    public String str_BrowserType = System.getProperty("Browser", "chrome");

    private static final String SYS_CLOSE_BROWSER_ON_FAILURE = "closeBrowserOnFailure";
    private static final String SYS_CLOSE_BROWSER_ON_PASS = "closeBrowserOnPass";

    BrowserFactory browserfactory = BrowserFactory.getInstance();

    public static String featureFileName;

    // 🔥 EXISTING (kept for backward compatibility)
    private String role = System.getProperty("role", "admin");

    // 🔥 NEW: Multi-role support
    private String roles = System.getProperty("roles", role);

    private Page page;

    @Before
    public void before(Scenario scenario) throws Exception {

        System.out.println("+++++++++++++++++++ BEFORE HOOK +++++++++++++++++++");

        if (!str_Execution_TYPE.equalsIgnoreCase("Web_UI")) {
            throw new Exception("[-] Please set execution type Web_UI");
        }

        ReportManager.startTest(scenario.getName(), "SMOKE");

        System.out.println("Execution started on browser: " + str_BrowserType);
        System.out.println("Running for ROLES: " + roles);

        try {
            // Step 1: Launch browser
            browserfactory.setBrowser(str_BrowserType);

            // 🔥 LOOP THROUGH ROLES
            for (String roleName : roles.split(",")) {

                roleName = roleName.trim();

                System.out.println("🔄 Initializing ROLE: " + roleName);

                Path fullPath = Paths.get(System.getProperty("user.dir"),
                        "auth/" + roleName.toLowerCase() + ".json");

                Page rolePage = browserfactory.initRoleSession(roleName);

                if (Files.exists(fullPath)) {
                    System.out.println("✅ Session found → Using saved login for role: " + roleName);
                } else {
                    System.out.println("⚠ No session found for role: " + roleName);
                    System.out.println("👉 Please login manually (OTP). Session will be saved after execution.");
                }

                if (rolePage == null) {
                    throw new RuntimeException("Page is NULL after initRoleSession for role: " + roleName);
                }

                System.out.println("Current URL (" + roleName + "): " + rolePage.url());

                // Start tracing per role
                if (rolePage.context() != null) {
                    rolePage.context().tracing().start(
                            new Tracing.StartOptions()
                                    .setScreenshots(true)
                                    .setSnapshots(true)
                    );
                }

                // 🔥 Keep first role page as default (for backward compatibility)
                if (page == null) {
                    page = rolePage;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @After
    public void after(Scenario scenario) throws Exception {

        System.out.println("+++++++++++++++++++ AFTER HOOK +++++++++++++++++++");

        String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

        totalTestCases.add(scenario.getName());

        if (scenario.isFailed()) {

            failedTests.add(scenario.getName());

            try {
                String base64Screenshot = Screenshot_Util.takeScreenshot();

                if (base64Screenshot != null && !base64Screenshot.isEmpty()) {
                    scenario.attach(base64Screenshot.getBytes(), "image/png", scenario.getName());
                } else {
                    System.out.println("⚠ Screenshot skipped: base64 is empty");
                }

            } catch (Exception e) {
                System.out.println("⚠ Screenshot failed: " + e.getMessage());
            }

            if (Boolean.parseBoolean(System.getProperty(SYS_CLOSE_BROWSER_ON_FAILURE, "false"))) {
                browserfactory.closeBrowser();
            }

        } else {
            passedTests.add(scenario.getName());
        }

        // 🔥 LOOP FOR SESSION SAVE + TRACING STOP
        for (String roleName : roles.split(",")) {

            roleName = roleName.trim();

            try {
                Page rolePage = browserfactory.getPage(roleName);

                if (rolePage != null && rolePage.context() != null) {

                    // Stop tracing
                    rolePage.context().tracing().stop(
                            new Tracing.StopOptions().setPath(Paths.get(
                                    System.getProperty("user.dir") +
                                            "/TracingReports/" + dateStamp + "/" +
                                            scenario.getName() + "_" + roleName + ".zip"))
                    );

                    String currentUrl = rolePage.url();

                    // Save session only if logged in
                    if (!currentUrl.toLowerCase().contains("login")) {

                        Path fullPath = Paths.get(System.getProperty("user.dir"),
                                "auth/" + roleName.toLowerCase() + ".json");

                        Files.createDirectories(fullPath.getParent());

                        System.out.println("💾 Saving session for role: " + roleName);

                        rolePage.context().storageState(
                                new com.microsoft.playwright.BrowserContext.StorageStateOptions()
                                        .setPath(fullPath)
                        );

                        System.out.println("✅ Session saved for role: " + roleName);

                    } else {
                        System.out.println("⚠ Session NOT saved for role: " + roleName + " (still on login page)");
                    }
                }

            } catch (Exception e) {
                System.out.println("⚠ Session save failed for role: " + roleName + " | " + e.getMessage());
            }
        }

        // Close browser
        boolean defaultCloseOnPass = true;

        if (Boolean.parseBoolean(System.getProperty(
                SYS_CLOSE_BROWSER_ON_PASS,
                String.valueOf(defaultCloseOnPass)))) {

            browserfactory.closeBrowser();
        }
    }
}