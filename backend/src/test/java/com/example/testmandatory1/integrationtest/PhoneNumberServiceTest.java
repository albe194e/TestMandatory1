package com.example.testmandatory1.integrationtest;

import com.example.testmandatory1.service.PhoneNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PhoneNumberServiceTest {

    @Autowired
    private PhoneNumberService phoneNumberService;

    @Test
    void testGeneratePhoneNumber() {
        // Act
        String phoneNumber = phoneNumberService.generatePhoneNumber();

        // Assert
        assertNotNull(phoneNumber);

    }
}
