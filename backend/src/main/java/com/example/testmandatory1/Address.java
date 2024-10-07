package com.example.testmandatory1;

import lombok.Getter;

@Getter
public class Address {
    
    private String street, number, floor, door, city, postalCode;

    public Address(String street, String number, String floor, String door, String city, String postalCode) {
        
        this.setStreet(street);
        this.setNumber(number);
        this.setFloor(floor);
        this.setDoor(door);
        this.setCity(city);
        this.setPostalCode(postalCode);
    }
    public Address() {}

    private void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    private void setCity(String city) {
        this.city = city;
    }
    private void setDoor(String door) {
        this.door = door;
    }
    private void setFloor(String floor) {
        this.floor = floor;
    }
    private void setNumber(String number) {
        this.number = number;
    }
    private void setStreet(String street) {

        if (!street.matches("[a-zA-Z]+")) {
            throw new ValidationException(String.format("{} can only contain alphabetic chars", street));
        }
        this.street = street;
    }
}   
