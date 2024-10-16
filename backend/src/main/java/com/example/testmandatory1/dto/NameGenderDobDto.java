package com.example.testmandatory1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameGenderDobDto {

    private String firstName;
    private String lastName;
    private String gender;
    private String dob;

    public NameGenderDobDto(String firstName, String lastName, String gender, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
    }
}
