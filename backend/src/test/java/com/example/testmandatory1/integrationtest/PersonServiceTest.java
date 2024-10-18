package com.example.testmandatory1.integrationtest;

import com.example.testmandatory1.model.Person;
import com.example.testmandatory1.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testDisplayRandomPerson() throws IOException {
        // Act
        Person nameGenderDto = personService.getRandomPerson();

        // Assert
        assertNotNull(nameGenderDto);
        assertNotNull(nameGenderDto.getName());
        assertNotNull(nameGenderDto.getSurname());
        assertNotNull(nameGenderDto.getGender());
    }


}