package com.example.testmandatory1.integrationtest;

import com.example.testmandatory1.PersonService;
import com.example.testmandatory1.dto.PersonDto;
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
        PersonDto nameGenderDto = personService.getRandomPerson();

        // Assert
        assertNotNull(nameGenderDto);
        assertNotNull(nameGenderDto.getFirstName());
        assertNotNull(nameGenderDto.getLastName());
        assertNotNull(nameGenderDto.getGender());
    }


}