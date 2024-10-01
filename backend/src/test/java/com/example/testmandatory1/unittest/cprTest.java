package com.example.testmandatory1.unittest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class cprTest {


    @Test
    public void testCpr() {
        // Arrange
        String cpr = "123456-1234";
        // Act
        boolean result = cpr.matches("^[0-9]{6}-[0-9]{4}$");
        // Assert
        assertTrue(result);
    }
}
