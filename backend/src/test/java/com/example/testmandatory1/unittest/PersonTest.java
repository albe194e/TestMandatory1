package com.example.testmandatory1.unittest;

import com.example.testmandatory1.model.Person;
import com.example.testmandatory1.service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {"spring.profiles.active=test"})
public class PersonTest {

    @SpyBean
    @Autowired
    private PersonService personService;

    @Test
    public void testDisplayRandomPerson() throws IOException {
        // Arrange
        List<Person> mockPersons = Arrays.asList(
                new Person("John", "Doe", "Male"),
                new Person("Jane", "Doe", "Female")
        );

        Mockito.doReturn(mockPersons).when(personService).loadPersonsFromFile();

        // Act
        Person person = personService.getRandomPerson();

        // Assert
        assertNotNull(person);
        assertTrue(person.getName().equals("John") || person.getName().equals("Jane"));
        assertNotNull(person.getGender());
    }

    @Test
    public void testDisplayRandomPerson_EmptyFile_ThrowError() throws IOException {
        // Arrange
        List<Person> emptyPersons = List.of();
        Mockito.doReturn(emptyPersons).when(personService).loadPersonsFromFile();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> personService.getRandomPerson());
    }

    @Test
    public void testGenerateCprCorrectInputAndFormat() {
        // Arrange
        String gender = "male";
        LocalDate dob = LocalDate.of(2015, 4, 19);
        // Act
        boolean result = personService.generateCpr(gender,
                dob).matches("^[0-9]{6}-[0-9]{4}$");
        // Assert
        assertTrue(result);
    }
}


