package com.example.testmandatory1.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class Person {

    private String cpr;
    private String name;
    private String surname;
    private String gender;

    private LocalDate dob;
    private Address address;

    private String phoneNumber;

    public Person(String name, String surname, String gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public Person() {
    }
}

