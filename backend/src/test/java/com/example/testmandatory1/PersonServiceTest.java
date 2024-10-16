package com.example.testmandatory1;

import com.example.testmandatory1.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void displayRandomPerson() {
    }

    @Test
    public void testGetRandomPerson() {
    }

}