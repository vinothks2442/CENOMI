package com.automation.web.common_utils;

import com.microsoft.playwright.Page;
import java.util.HashMap;
import java.util.Map;

public class RoleContext {

    private static final Map<String, Page> rolePages = new HashMap<>();

    public static void setPage(String role, Page page) {
        rolePages.put(role.toLowerCase(), page);
    }

    public static Page getPage(String role) {
        Page page = rolePages.get(role.toLowerCase());

        if (page == null) {
            throw new RuntimeException("❌ No page found for role: " + role);
        }
        return page;
    }
}