package com.example.testmandatory1.dto;

import com.example.testmandatory1.model.Person;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PersonDto {

    private String cpr;
    private String firstName;
    private String lastName;
    private String gender;
    private String dob;

    public PersonDto(Person person) {
        this.cpr = person.getCpr();
        this.firstName = person.getName();
        this.lastName = person.getSurname();
        this.gender = person.getGender();
        this.dob = person.getDob();
    }
}
