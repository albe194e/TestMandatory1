package com.example.testmandatory1.service;

import com.example.testmandatory1.utility.PhoneNumberConstants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PhoneNumberService {

    private final Random random = new Random();
    private static final List<String> VALID_PREFIXES = PhoneNumberConstants.VALID_PREFIXES;

    public String generatePhoneNumber() {
        String prefix = VALID_PREFIXES.get(random.nextInt(VALID_PREFIXES.size()));
        int remainingDigits = 8 - prefix.length();

        StringBuilder phoneNumber = new StringBuilder(prefix);
        for (int i = 0; i < remainingDigits; i++) {
            phoneNumber.append(random.nextInt(10));
        }

        return phoneNumber.toString();
    }

    public boolean isValidPrefix(String phoneNumber) {
        return VALID_PREFIXES.stream().anyMatch(phoneNumber::startsWith);
    }
}
