package com.automation.web.common_utils;

import com.microsoft.playwright.*;

public class MicrosoftLoginUtil {

    public static void loginWithMicrosoft(Page page) throws Exception {

        page.fill("input[type=email]", ConfigReader.getValue("adminEmail"));
        page.click("input[type=submit]");

        page.fill("input[type=password]", ConfigReader.getValue("adminPassword"));
        page.click("input[type=submit]");

        page.waitForSelector("input[name=otc]");

        String otp = EmailOTPReader.getOTP(
                ConfigReader.getValue("adminEmail"),
                ConfigReader.getValue("emailPassword")
        );

        page.fill("input[name=otc]", otp);
        page.click("input[type=submit]");
    }
}