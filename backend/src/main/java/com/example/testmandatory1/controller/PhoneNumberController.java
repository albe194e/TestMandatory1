package com.example.testmandatory1.controller;

import com.example.testmandatory1.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneNumberController {

    @Autowired
    private PhoneNumberService phoneNumberService;

    @GetMapping("/phoneNumber")
    public ResponseEntity<String> getPhoneNumber() {
        return ResponseEntity.ok(phoneNumberService.generatePhoneNumber());
    }
}
