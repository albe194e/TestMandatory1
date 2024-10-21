package com.example.testmandatory1.service;

import com.example.testmandatory1.ValidationException;
import com.example.testmandatory1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonGenerationService {

    @Autowired
    private PersonService personService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private PhoneNumberService phoneNumberService;


    public List<Person> generatePerson(int number) throws IOException {

        if (number < 2 || number > 100) {
            throw new ValidationException("Number must be greater than 2 and less than 100");
        }
        ArrayList<Person> people = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            Person person = personService.getRandomPerson();
            person.setAddress(addressService.generateAddress());
            person.setPhoneNumber(phoneNumberService.generatePhoneNumber());
            people.add(person);
        }
        return people;
    }
}


