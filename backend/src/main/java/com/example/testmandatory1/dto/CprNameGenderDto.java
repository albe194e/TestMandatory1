package com.example.testmandatory1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CprNameGenderDto {

    private String cpr;
    private String firstName;
    private String lastName;
    private String gender;

    public CprNameGenderDto(String cpr, String firstName, String lastName, String gender) {
        this.cpr = cpr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
}
