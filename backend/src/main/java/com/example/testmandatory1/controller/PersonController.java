package com.example.testmandatory1.controller;

import com.example.testmandatory1.ValidationException;
import com.example.testmandatory1.dto.AddressDto;
import com.example.testmandatory1.model.Address;
import com.example.testmandatory1.model.Person;
import com.example.testmandatory1.service.AddressService;
import com.example.testmandatory1.service.PersonService;
import com.example.testmandatory1.service.PhoneNumberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin
public class PersonController {

    private final PersonService personService;
    private final AddressService addressService;
    private final PhoneNumberService phoneNumberService;

    public PersonController(PersonService personService, AddressService addressService, PhoneNumberService phoneNumberService) {
        this.personService = personService;
        this.addressService = addressService;
        this.phoneNumberService = phoneNumberService;
    }


    @GetMapping("/person")
    public ResponseEntity<Person> getPerson() {
        try {
            Person randomPerson = personService.getRandomPerson();
            return ResponseEntity.ok(randomPerson);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/detailed-person")
    public ResponseEntity<Person> getDetailedPerson() {
        try {
            Person randomPerson = personService.getRandomPerson();
            randomPerson.setAddress(addressService.generateAddress());
            randomPerson.setPhoneNumber(phoneNumberService.generatePhoneNumber());

            return ResponseEntity.ok(randomPerson);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(value = "/address")
    public ResponseEntity<Address> getAddress() {

        try {
            return ResponseEntity.ok(addressService.generateAddress());
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/people/{number}")
    public void getPeople(@PathVariable String number) {
    }

    @GetMapping("/phone")
    public ResponseEntity<String> getPhoneNumber() {
        return ResponseEntity.ok(phoneNumberService.generatePhoneNumber());
    }
}
