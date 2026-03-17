package com.automation.web.Report_Utils;

import java.nio.file.Paths;
import java.util.Base64;

import com.automation.web.common_utils.BrowserFactory;
import com.microsoft.playwright.Page;

public class Screenshot_Util {
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		//getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));

		Page page = BrowserFactory.getInstance().getPage();
		if (page == null) {
			// If page is not initialized (e.g. browser failed to start), avoid NPE and return empty string
			System.out.println("Screenshot skipped: Playwright page is null");
			return "";
		}

		byte[] buffer = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);

		return base64Path;
	}
}
