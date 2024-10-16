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

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setDoor(String door) {
        String doorRegex = "^(th|mf|tv|([1-9]|[1-4][0-9]|50)|([a-z]-?[0-9]{1,3}))$";

        if (door.matches(doorRegex)) {
            this.door = door;
        } else {
            throw new ValidationException("Door: {" + door + "} must match \"th\", \"mf\", \"tv\", a number 1-50, or a lowercase letter followed by optional '-' and 1-3 digits (e.g., c3, d-14)");
        }
    }
    public void setFloor(String floor) {

        if (floor.equals("st") || floor.matches("^([1-9][0-9]?)$")) {
            this.floor = floor;
        } else {
            throw new ValidationException("Floor: {" + floor + "} must either be \"st\" or \"1-99\"");
        }
    }
    public void setNumber(String number) {

        String numberAndLetterRegex = "([1-9][0-9]{0,2})([A-Z])";
        String numberOnlyRegex = "^([1-9][0-9]{0,2})$";
        if (number.matches(numberAndLetterRegex) || number.matches(numberOnlyRegex)) {
            this.number = number;
        } else {
            throw new ValidationException("Number: {" + number +  "} must match pattern either 1-999 (ex: 536) or 1-999A-Z (ex: 534B)");
        }
    }
    public void setStreet(String street) {

        if (!street.matches("[a-zA-Z]+")) {
            throw new ValidationException(String.format("{} can only contain alphabetic chars", street));
        }

        if (street.length() < 3 && street.length() > 30) {
            throw new ValidationException(String.format("{} Street name should be shorter than 2 chars and longer than 30", street));
        }

        this.street = street;
    }
}   
