package com.automation.web.common_utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import com.automation.web.Report_Utils.ReportManager;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;

public class BrowserFactory {

    static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    static ThreadLocal<Page> tlPage = new ThreadLocal<>();

    // 🔥 Multi-role support
    static ThreadLocal<Map<String, BrowserContext>> tlRoleContexts =
            ThreadLocal.withInitial(HashMap::new);

    static ThreadLocal<Map<String, Page>> tlRolePages =
            ThreadLocal.withInitial(HashMap::new);

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

    public Page getPage(String role) {
        return tlRolePages.get().get(role);
    }

    // ==========================
    // 🔥 Browser Setup (FIXED)
    // ==========================
    public void setBrowser(String browser) {

        String sessionMode = System.getProperty("session", "fresh");
        System.out.println("Session Mode : " + sessionMode);
        ReportManager.logInfo("Session Mode : " + sessionMode);

        boolean clearSession = Boolean.parseBoolean(System.getProperty("clearSession", "false"));

        if (clearSession) {
            System.out.println("Clearing saved browser session (clearSession=true)");
            ReportManager.logInfo("Clearing saved browser session (clearSession=true)");
        }

        closeBrowser();

        tlPlaywright.set(Playwright.create());

        String dimensions = System.getProperty("Dimension", "default");
        int[] pixels = setDimensions(dimensions);

        BrowserType.LaunchOptions launchOptions =
                new BrowserType.LaunchOptions().setHeadless(false);

        switch (browser.toLowerCase()) {

            case "chromium":
                tlBrowser.set(getPlaywright().chromium().launch(launchOptions));
                break;

            case "chrome":
                tlBrowser.set(getPlaywright().chromium().launch(
                        new BrowserType.LaunchOptions()
                                .setChannel("chrome")
                                .setHeadless(false)));
                break;

            case "edge":
                tlBrowser.set(getPlaywright().chromium().launch(
                        new BrowserType.LaunchOptions()
                                .setChannel("msedge")
                                .setHeadless(false)));
                break;

            case "firefox":
                tlBrowser.set(getPlaywright().firefox().launch(launchOptions));
                break;

            case "safari":
                tlBrowser.set(getPlaywright().webkit().launch(launchOptions));
                break;

            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }

        // ✅ IMPORTANT FIX:
        // Do NOT create default context/page here
        // Role session will handle context + page creation

        tlBrowserContext.remove();
        tlPage.remove();
    }

    // ==========================
    // 🔥 Role Session (FIXED)
    // ==========================
    public Page initRoleSession(String role) {

        if (tlRolePages.get().containsKey(role)) {
            return tlRolePages.get().get(role);
        }

        int[] pixels = setDimensions(System.getProperty("Dimension", "default"));
        String storagePath = getStoragePath(role);

        Path fullPath = Paths.get(System.getProperty("user.dir"), storagePath);

        Browser.NewContextOptions options = new Browser.NewContextOptions()
                .setViewportSize(pixels[0], pixels[1])
                .setAcceptDownloads(true)
                .setPermissions(Arrays.asList("geolocation"))
                .setGeolocation(new Geolocation(13.9591, 79.5808));

        // ✅ Load session only if exists
        if (Files.exists(fullPath)) {
            System.out.println("🔁 Loading session: " + fullPath.toAbsolutePath());
            options.setStorageStatePath(fullPath);
        } else {
            System.out.println("🆕 No session found. Fresh login required for role: " + role);
        }

        BrowserContext context = getBrowser().newContext(options);
        Page page = context.newPage();

        tlRoleContexts.get().put(role, context);
        tlRolePages.get().put(role, page);

        // ✅ Set main thread page also (important for legacy code)
        tlPage.set(page);

        return page;
    }

    // ==========================
    // 🔥 Save Session
    // ==========================
    public void saveSession(String role) {

        try {
            Page page = getPage(role);

            if (page == null || page.context() == null) {
                System.out.println("❌ Page/context null. Cannot save session.");
                return;
            }

            Path fullPath = Paths.get(System.getProperty("user.dir"), getStoragePath(role));

            Files.createDirectories(fullPath.getParent());

            System.out.println("💾 Saving session at: " + fullPath.toAbsolutePath());

            page.context().storageState(
                    new BrowserContext.StorageStateOptions().setPath(fullPath)
            );

            System.out.println("✅ Session saved successfully for role: " + role);

        } catch (Exception e) {
            System.out.println("⚠ Session save failed: " + e.getMessage());
        }
    }

    // ==========================
    // 🔥 Role Path Mapping
    // ==========================
    private String getStoragePath(String role) {
        switch (role.toLowerCase()) {
            case "admin":
                return "auth/admin.json";
            case "mallmanager":
            case "mall manager":
                return "auth/mall_manager.json";
            case "fmmanager":
            case "fm manager":
                return "auth/fm_manager.json";
            case "rddmanager":
            case "rdd manager":
                return "auth/rdd_manager.json";
            default:
                throw new RuntimeException("Invalid role: " + role);
        }
    }

    // ==========================
    // 🔥 Screen Size
    // ==========================
    public int[] setDimensions(String dimensions) {

        int width;
        int height;

        if (dimensions == null || dimensions.equalsIgnoreCase("default")) {

            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            width = (int) screen.getWidth();
            height = (int) screen.getHeight();

        } else {
            String[] parts = dimensions.split("\\*");
            width = Integer.parseInt(parts[0]);
            height = Integer.parseInt(parts[1]);
        }

        return new int[]{width, height};
    }

    // ==========================
    // 🔥 Close Browser
    // ==========================
    public void closeBrowser() {
        try {

            if (tlRoleContexts.get() != null) {
                tlRoleContexts.get().values().forEach(ctx -> {
                    try { ctx.close(); } catch (Exception ignored) {}
                });
            }

            if (tlBrowserContext.get() != null) {
                tlBrowserContext.get().close();
            }

            if (tlBrowser.get() != null) {
                tlBrowser.get().close();
            }

            if (tlPlaywright.get() != null) {
                tlPlaywright.get().close();
            }

        } catch (Exception ignored) {}

        tlRoleContexts.remove();
        tlRolePages.remove();
        tlPage.remove();
        tlBrowserContext.remove();
        tlBrowser.remove();
        tlPlaywright.remove();
    }
}