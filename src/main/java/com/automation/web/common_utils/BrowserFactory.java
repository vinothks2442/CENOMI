package com.automation.web.common_utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.automation.web.Report_Utils.ReportManager;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Geolocation;

public class BrowserFactory {

    static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    static ThreadLocal<Page> tlPage = new ThreadLocal<>();

    public static BrowserFactory instance = null;

    private BrowserFactory() {}

    public static BrowserFactory getInstance() {

        if (instance == null) {
            instance = new BrowserFactory();
        }
        return instance;
    }

    public Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    public Browser getBrowser() {
        return tlBrowser.get();
    }

    public BrowserContext getBrowserContext() {
        return tlBrowserContext.get();
    }

    public Page getPage() {
        return tlPage.get();
    }

    public void setBrowser(String browser) {

        tlPlaywright.set(Playwright.create());

        String sessionMode = System.getProperty("session", "fresh");
        System.out.println("Session Mode : " + sessionMode);
        ReportManager.logInfo("Session Mode : " + sessionMode);

        boolean clearSession = Boolean.parseBoolean(System.getProperty("clearSession", "false"));
        if (clearSession) {
            System.out.println("Clearing saved browser session (clearSession=true)");
            ReportManager.logInfo("Clearing saved browser session (clearSession=true)");
        }

        String dimensions = System.getProperty("Dimension", "default");
        int[] pixels = setDimensions(dimensions);

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false);

        switch (browser.toLowerCase()) {

            case "chromium":
                tlBrowser.set(getPlaywright().chromium().launch(launchOptions));
                break;

            case "chrome":
                tlBrowser.set(getPlaywright().chromium().launch(
                        new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;

            case "edge":
                tlBrowser.set(getPlaywright().chromium().launch(
                        new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false)));
                break;

            case "firefox":
                tlBrowser.set(getPlaywright().firefox().launch(launchOptions));
                break;

            case "safari":
                tlBrowser.set(getPlaywright().webkit().launch(launchOptions));
                break;

            default:
                System.out.println("Please pass the correct browser name...");
                break;
        }

        // -------- Persistent Session --------
        if (sessionMode.equalsIgnoreCase("persistent")) {

            Path userDataDir = Paths.get(System.getProperty("user.dir"), "browser-session");
            if (clearSession) {
                deleteDirectoryQuietly(userDataDir);
            }

            System.out.println("Persistent session dir: " + userDataDir.toAbsolutePath());
            ReportManager.logInfo("Persistent session dir: " + userDataDir.toAbsolutePath());

            BrowserType.LaunchPersistentContextOptions options =
                    new BrowserType.LaunchPersistentContextOptions()
                            .setHeadless(false)
                            .setViewportSize(pixels[0], pixels[1])
                            .setAcceptDownloads(true)
                            .setPermissions(Arrays.asList("geolocation"))
                            .setGeolocation(new Geolocation(13.9591, 79.5808));

            tlBrowserContext.set(
                    getPlaywright().chromium()
                            .launchPersistentContext(userDataDir, options)
            );

        }

        // -------- Fresh Session --------
        else {

            tlBrowserContext.set(getBrowser().newContext(
                    new Browser.NewContextOptions()
                            .setViewportSize(pixels[0], pixels[1])
                            .setAcceptDownloads(true)
                            .setPermissions(Arrays.asList("geolocation"))
                            .setGeolocation(new Geolocation(13.9591, 79.5808))
            ));

        }

        // When using a persistent context, Playwright may already open a default page.
        // To avoid having two tabs, reuse the existing page if present; otherwise create a new one.
        List<Page> existingPages = getBrowserContext().pages();
        if (existingPages != null && !existingPages.isEmpty()) {
            tlPage.set(existingPages.get(0));
        } else {
            tlPage.set(getBrowserContext().newPage());
        }
    }

    public int[] setDimensions(String dimensions) {

        int width;
        int height;

        String dim = dimensions == null ? "" : dimensions.trim();

        // Fallback to default when not set, blank, or explicitly "default"
        if (dim.isEmpty() || dim.equalsIgnoreCase("default")) {

            Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
            width = (int) screensize.getWidth();
            height = (int) screensize.getHeight();

            System.out.println("Default window size: " + width + " * " + height);
            ReportManager.logInfo("Default window size: " + width + " * " + height);

        } else {

            try {
                String[] hit = dim.split("\\*");
                if (hit.length != 2) {
                    throw new NumberFormatException("Invalid Dimension format: " + dim);
                }
                width = Integer.parseInt(hit[0].trim());
                height = Integer.parseInt(hit[1].trim());
                System.out.println("Window size detected : " + width + " * " + height);
                ReportManager.logInfo("Window size detected : " + width + " * " + height);
            } catch (Exception e) {
                // On any parsing issue, safely fall back to default screen size
                Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
                width = (int) screensize.getWidth();
                height = (int) screensize.getHeight();
                System.out.println("Invalid Dimension value '" + dim + "', using default: " + width + " * " + height);
                ReportManager.logInfo("Invalid Dimension value '" + dim + "', using default: " + width + " * " + height);
            }
        }

        return new int[]{width, height};
    }

    public void closeBrowser() {
        try {
            if (tlBrowserContext.get() != null) {
                try {
                    tlBrowserContext.get().close();
                } catch (Exception ignored) {
                }
            }

            if (tlBrowser.get() != null) {
                try {
                    tlBrowser.get().close();
                } catch (Exception ignored) {
                }
            }

            if (tlPlaywright.get() != null) {
                try {
                    tlPlaywright.get().close();
                } catch (Exception ignored) {
                }
            }
        } finally {
            // Ensure we never hold stale/closed instances in ThreadLocals
            try { tlPage.remove(); } catch (Exception ignored) {}
            try { tlBrowserContext.remove(); } catch (Exception ignored) {}
            try { tlBrowser.remove(); } catch (Exception ignored) {}
            try { tlPlaywright.remove(); } catch (Exception ignored) {}
        }
    }

    private void deleteDirectoryQuietly(Path dir) {
        try {
            if (dir == null || !Files.exists(dir)) {
                return;
            }
            // Delete children first, then the directory itself.
            Files.walk(dir)
                    .sorted(Comparator.reverseOrder())
                    .forEach(path -> {
                        try {
                            Files.deleteIfExists(path);
                        } catch (IOException ignored) {
                            // best-effort cleanup
                        }
                    });
        } catch (Exception ignored) {
            // best-effort cleanup
        }
    }
}