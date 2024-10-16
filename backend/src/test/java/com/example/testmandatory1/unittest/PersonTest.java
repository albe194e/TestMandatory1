package com.example.testmandatory1.unittest;

import com.example.testmandatory1.dto.PersonDto;
import com.example.testmandatory1.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testGetRandomPerson() throws IOException {
        // Arrange & Act
        PersonDto personDto = personService.getRandomPerson();

        assertNotNull(personDto);
        assertNotNull(personDto.getCpr());
        assertNotNull(personDto.getDob());
    }
}

