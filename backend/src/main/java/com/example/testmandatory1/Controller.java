package com.example.testmandatory1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public void getFirstnameLastnameGender() {
    }

    @GetMapping("/firstname_lastname_gender_dob")
    public void getFirstnameLastnameGenderDob() {
    }

    @GetMapping("/cpr_firstname_lastname_gender")
    public void getCprFirstnameLastnameGender() {
    }

    @GetMapping("/cpr_firstname_lastname_gender_dob")
    public void getCprFirstnameLastnameGenderDob() {
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
