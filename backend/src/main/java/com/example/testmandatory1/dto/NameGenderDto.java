package com.example.testmandatory1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameGenderDto {

    private String firstName;
    private String lastName;
    private String gender;

    public NameGenderDto(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
}
