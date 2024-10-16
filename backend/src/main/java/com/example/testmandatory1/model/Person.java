package com.example.testmandatory1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

@Data
@ToString
public class Person {

    private String cpr;
    private String name;
    private String surname;
    private String gender;

    private String dob;

    private Address address;

    private String phoneNumber;

    public Person(String name, String surname, String gender, String dob, String cpr) {
        this.name = name;
        this.surname = surname;
        this.gender = gender.substring(0, 1).toUpperCase() + gender.substring(1).toLowerCase();
        this.dob = dob;
        this.cpr = cpr;
    }

    public Person(String gender, String surname, String name) {
        this.gender = gender;
        this.surname = surname;
        this.name = name;
    }

    public Person() {
    }

}

