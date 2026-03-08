package com.automation.web.common_utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.automation.web.Report_Utils.ReportManager;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Geolocation;

public class BrowserFactory {

	static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	static ThreadLocal<Page> tlPage = new ThreadLocal<>();

	public static BrowserFactory instance = null;
	public static Playwright playwright;
	public static Browser browse;

	private BrowserFactory() {

	}

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

	public void setBrowser(String Browser) {

		// playwright = Playwright.create();
		tlPlaywright.set(Playwright.create());

		switch (Browser.toLowerCase()) {
		case "chromium":
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "firefox":
			tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "safari":
			tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "chrome":
			tlBrowser.set(
					getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false)));
			break;
		case "edge":
			tlBrowser.set(
					getPlaywright().chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false)));
			break;

		default:
			System.out.println("please pass the right browser name......");
			break;
		}

		String dimensions = System.getProperty("Dimension");
		int[] pixels = setDimensions(dimensions);
		tlBrowserContext.set(getBrowser().newContext(
				new Browser.NewContextOptions().setViewportSize(pixels[0], pixels[1]).setAcceptDownloads(true)
				.setPermissions(Arrays.asList("geolocation")) 
                .setGeolocation(new Geolocation(13.9591, 79.5808))));
		tlPage.set(getBrowserContext().newPage());
	}

	public int[] setDimensions(String dimensions) {

		int width;
		int height;
		if (dimensions.equalsIgnoreCase("default")) {
			Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
			width = (int) screensize.getWidth();
			height = (int) screensize.getHeight();
			System.out.println("Default window size: " + width + " * " + height);
			ReportManager.logInfo("Default window size: " + width + " * " + height);
		} else {
			String[] hit = (dimensions.split("\\*"));
			String x = hit[0];
			String y = hit[1];
			width = Integer.parseInt(x);
			height = Integer.parseInt(y);
			System.out.println("Window size detected : " + width + " * " + height);
			ReportManager.logInfo("Window size detected : " + width + " * " + height);
		}
		int[] pixels = { width, height };
		return pixels;
	}

}
