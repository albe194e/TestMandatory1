package com.example.testmandatory1.controller;

import com.example.testmandatory1.Address;
import com.example.testmandatory1.ValidationException;
import com.example.testmandatory1.dto.AddressDto;
import com.example.testmandatory1.dto.PersonDto;
import com.example.testmandatory1.model.Person;
import com.example.testmandatory1.service.AddressService;
import com.example.testmandatory1.service.PersonService;
import com.example.testmandatory1.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private PhoneNumberService phoneNumberService;


    @GetMapping("/person")
    public ResponseEntity<PersonDto> getPerson() {
        try {
            PersonDto randomPerson = personService.getRandomPerson();
            return ResponseEntity.ok(randomPerson);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(value = "/address")
    public ResponseEntity<AddressDto> getAddress() {

        try {
            return ResponseEntity.ok(addressService.generateAddress());
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable String id) {
        return new Person();
    }

    @GetMapping("/people/{number}")
    public void getPeople(@PathVariable String number) {
    }

    @GetMapping("/phoneNumber")
    public ResponseEntity<String> getPhoneNumber() {
        return ResponseEntity.ok(phoneNumberService.generatePhoneNumber());
    }
}
