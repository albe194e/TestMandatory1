package com.example.testmandatory1.integrationtest;

import com.example.testmandatory1.model.Person;
import com.example.testmandatory1.service.PersonGenerationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PersonGenerationServiceTest {

    @Autowired
    private PersonGenerationService personGenerationServiceService;

    @Test
    public void testGeneratePerson() throws IOException {
        // Act
        List<Person> people = personGenerationServiceService.generatePerson(5);

        // Assert
        assertNotNull(people);
        assertEquals(5, people.size());
        for (Person person : people) {
            assertNotNull(person);
            assertNotNull(person.getName());
            assertNotNull(person.getSurname());
            assertNotNull(person.getGender());
            assertNotNull(person.getDob());
            assertNotNull(person.getCpr());
            assertNotNull(person.getAddress());
            assertNotNull(person.getPhoneNumber());
        }
    }
}
