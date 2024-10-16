package com.example.testmandatory1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService service;

    @Test
    void displayRandomPerson() {
    }

    @Test
    public void testGetRandomPerson() {
    }

}