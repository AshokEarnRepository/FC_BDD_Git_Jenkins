package com.qa.Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class EmailGenerator {

    public static String generateRandomEmail() {
        // Generate a random string of length 10 for the email username
        String randomUsername = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
        
        // Concatenate the username with the yopmail domain
        return randomUsername + "@yopmail.com";
    }
}
