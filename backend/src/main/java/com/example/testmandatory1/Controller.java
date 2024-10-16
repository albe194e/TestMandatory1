package com.example.testmandatory1;

import com.example.testmandatory1.dto.CprNameGenderDobDto;
import com.example.testmandatory1.dto.CprNameGenderDto;
import com.example.testmandatory1.dto.NameGenderDto;
import com.example.testmandatory1.dto.NameGenderDobDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Controller {

    @Autowired
    private Service service;
    @Autowired
    private AddressService addressService;

    @GetMapping("/cpr")
    public String getCpr() {
        return "123456-7890";
    }

    @GetMapping("/firstname_lastname_gender")
    public ResponseEntity<NameGenderDto> getFirstnameLastnameGender() {
        try {
            NameGenderDto randomPerson = service.displayRandomPerson();
            return ResponseEntity.ok(randomPerson);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/firstname_lastname_gender_dob")
    public ResponseEntity<NameGenderDobDto> getFirstnameLastnameGenderDob() {
        try {
            NameGenderDobDto randomPerson = service.displayRandomPersonWithDob();
            // TODO: ADD DOB TO THE RESPONSE
            return ResponseEntity.ok(randomPerson);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/cpr_firstname_lastname_gender")
    public ResponseEntity<CprNameGenderDto> getCprFirstnameLastnameGender() {
        try {
            CprNameGenderDto randomPerson = service.displayRandomPersonWithCpr();
            // TODO: ADD CPR TO THE RESPONSE
            return ResponseEntity.ok(randomPerson);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/cpr_firstname_lastname_gender_dob")
    public ResponseEntity<CprNameGenderDobDto> getCprFirstnameLastnameGenderDob() {
        try {
            CprNameGenderDobDto randomPerson = service.displayRandomPersonWithCprAndDob();
            // TODO: ADD CPR AND DOB TO THE RESPONSE
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

    @GetMapping("/phoneNumber")
    public String getPhoneNumber() {
        return service.generatePhoneNumber();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable String id) {
        return new Person();
    }

    @GetMapping("/people/{number}")
    public void getPeople(@PathVariable String number) {
    }
}
