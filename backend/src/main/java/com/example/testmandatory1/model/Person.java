package com.example.testmandatory1.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

@Data
@ToString
public class Person {

    private String cpr;
    private String firstName;
    private String lastName;
    private String gender;

    private String dob;

    private Address address;

    private String phoneNumber;

    public Person(String firstName, String lastName, String gender, String dob, String cpr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender.substring(0, 1).toUpperCase() + gender.substring(1).toLowerCase();
        this.dob = dob;
        this.cpr = cpr;
    }

    public Person(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Person() {
    }

}

