package com.example.testmandatory1.unittest;

import com.example.testmandatory1.Person;
import com.example.testmandatory1.PersonService;
import com.example.testmandatory1.dto.NameGenderDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonTest {

    @Autowired
    private PersonService personService;

    @MockBean
    private PersonService mockPersonService;

    @Test
    public void testDisplayRandomPerson() throws IOException {
        // Arrange
        List<Person> mockPersons = Arrays.asList(
                new Person("John", "Doe", "Male"),
                new Person("Jane", "Doe", "Female")
        );

        // Mocking getRandomPerson() to return the first person from the list
        Mockito.when(mockPersonService.getRandomPerson()).thenReturn(mockPersons.getFirst());

        // Act
        NameGenderDto nameGenderDto = mockPersonService.displayRandomPerson();

        // Assert
        assertNotNull(nameGenderDto);
        assertEquals("John", nameGenderDto.getFirstName());
        assertEquals("Doe", nameGenderDto.getLastName());
        assertEquals("Male", nameGenderDto.getGender());
    }
}