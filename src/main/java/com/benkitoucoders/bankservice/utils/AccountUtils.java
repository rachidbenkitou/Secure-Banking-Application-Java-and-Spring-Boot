package com.benkitoucoders.bankservice.utils;

import java.time.Year;

public class AccountUtils {
    /**
     * 2024 + randomSixDigits
     */
    public static String generateAccountNumber() {

        Year currentYear = Year.now();
        int min = 100_000;
        int max = 999_999;

        // generate a random number between min and max
        int randNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
        // convert the current abd randomNumber to strings, then concatenate them
        String year = String.valueOf(currentYear);
        String randomNumber = String.valueOf(randNumber);
        StringBuilder accountNumber = new StringBuilder();
        return accountNumber.append(year).append(randomNumber).toString();
    }
}
