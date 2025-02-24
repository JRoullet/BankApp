package jroullet83.msaccounts.util;

import jroullet83.msaccounts.model.Customer;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;

public class AccountNumberGenerator {

    public static long generateAccountNumber(Customer customerId, LocalDate createDt, String accountType, LocalTime time) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String text = customerId.getCustomerId() + createDt.toString() + accountType + time.toString();
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            // Prendre les 6 premiers bytes du hachage et les convertir en long
            long accountNumber= bytesToLong(hash, 6);
            return accountNumber % 1_000_000_000_000L;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating account number", e);
        }
    }

    private static long bytesToLong(byte[] bytes, int length) {
        long value = 0;
        for (int i = 0; i < length; i++) {
            value = (value << 8) | (bytes[i] & 0xff);
        }
        return value;
    }
}
