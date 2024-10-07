package com.example.testmandatory1;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

public class Person {

    private String cpr;
    private String firstName;
    private String lastName;
    private char gender;

    private String dob;

    private Address address;

    private String phoneNumber;
}
