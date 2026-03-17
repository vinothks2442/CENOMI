package com.automation.web.common_utils;

import javax.mail.*;
import java.util.Properties;
import java.util.regex.*;

public class EmailOTPReader {

    public static String getOTP(String email, String password) throws Exception {

        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");

        Session session = Session.getInstance(props);

        Store store = session.getStore("imaps");
        store.connect("outlook.office365.com", email, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();

        for (int i = messages.length - 1; i >= 0; i--) {

            String content = messages[i].getContent().toString();

            Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
            Matcher matcher = pattern.matcher(content);

            if (matcher.find()) {
                return matcher.group();
            }
        }

        throw new RuntimeException("OTP not found");
    }
}