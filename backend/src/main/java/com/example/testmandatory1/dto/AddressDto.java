package com.example.testmandatory1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class AddressDto {

    private String street, number, floor, door, city, postalCode;

}
