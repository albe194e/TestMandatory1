package com.example.testmandatory1.unittest;

import com.example.testmandatory1.service.PhoneNumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberServiceTest {

    private PhoneNumberService phoneNumberService;

    @BeforeEach
    void setUp() {
        phoneNumberService = new PhoneNumberService();
    }

    @Test
    void testGeneratePhoneNumber_ValidLength() {
        String phoneNumber = phoneNumberService.generatePhoneNumber();

        // Test that the generated phone number has 8 digits
        assertEquals(8, phoneNumber.length(), "Generated phone number should be 8 digits long.");
    }

    @Test
    void testGeneratePhoneNumber_ValidPrefix() {
        String phoneNumber = phoneNumberService.generatePhoneNumber();

        // Test that the generated phone number starts with a valid prefix
        assertTrue(phoneNumberService.isValidPrefix(phoneNumber), "Generated phone number should start with a valid prefix.");
    }

    @Test
    void testIsValidPrefix_ValidPrefixes() {
        // Test for a few known valid prefixes
        assertTrue(phoneNumberService.isValidPrefix("21234567"), "The prefix '2' should be valid.");
        assertTrue(phoneNumberService.isValidPrefix("30234567"), "The prefix '30' should be valid.");
        assertTrue(phoneNumberService.isValidPrefix("34523456"), "The prefix '345' should be valid.");
    }

    @Test
    void testIsValidPrefix_InvalidPrefixes() {
        // Test for an invalid prefix
        assertFalse(phoneNumberService.isValidPrefix("99999999"), "The prefix '99' should be invalid.");
        assertFalse(phoneNumberService.isValidPrefix("12345678"), "The prefix '1' should be invalid.");
        assertFalse(phoneNumberService.isValidPrefix("00000000"), "The prefix '0' should be invalid.");
    }

    @Test
    void testGeneratePhoneNumber_Uniqueness() {
        // Generate a few phone numbers and test uniqueness
        String phoneNumber1 = phoneNumberService.generatePhoneNumber();
        String phoneNumber2 = phoneNumberService.generatePhoneNumber();
        String phoneNumber3 = phoneNumberService.generatePhoneNumber();

        assertNotEquals(phoneNumber1, phoneNumber2, "Generated phone numbers should be unique.");
        assertNotEquals(phoneNumber1, phoneNumber3, "Generated phone numbers should be unique.");
        assertNotEquals(phoneNumber2, phoneNumber3, "Generated phone numbers should be unique.");
    }
}
