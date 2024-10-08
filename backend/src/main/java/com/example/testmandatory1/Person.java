package com.example.testmandatory1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

@Getter
@Setter
@ToString
public class Person {

    private String cpr;
    private String name;
    private String surname;
    private String gender;

    private String dob;

    private Address address;

    private String phoneNumber;

    public Person(String name, String surname, String gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender.substring(0, 1).toUpperCase() + gender.substring(1).toLowerCase();
    }

    public Person() {
    }
}

