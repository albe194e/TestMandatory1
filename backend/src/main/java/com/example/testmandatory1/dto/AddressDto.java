package com.example.testmandatory1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDto {

    private String street, number, floor, door, city, postalCode;
    
}
