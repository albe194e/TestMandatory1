package com.example.testmandatory1.unittest;

import com.example.testmandatory1.model.Person;
import com.example.testmandatory1.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class cprTest {

    PersonService personService = new PersonService();

    /*@Test
    public void testCpr() {

        // Arrange
        personService.generateCpr("m", "01-01-2019");
        personService.generateCpr("f", "01-01-2019");
        personService.generateCpr("F", "01-01-2019");
        personService.generateCpr("M", "01-01-2019");
        personService.generateCpr("p", "01-01-2019");
        personService.generateCpr("m", "1101-01-19");
        personService.generateCpr("p", "1101-01-19");
        personService.generateCpr("M", "1101-01-19");
        personService.generateCpr("f", "lorem ipsum");

        All right inputs, right formats
        All right inputs, wrong formats
        All wrong inputs, wrong formats
        All wrong inputs, right formats
        1 right, 1 wrong, right formats
        1 right, 1 wrong, wrong formats


        // Act
        boolean result = cpr.matches("^[0-9]{6}-[0-9]{4}$");
        // Assert
        assertTrue(result);
    }*/
}
