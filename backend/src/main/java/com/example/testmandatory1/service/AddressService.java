package com.example.testmandatory1.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.example.testmandatory1.model.Address;
import com.example.testmandatory1.repository.AddressRepository;
import com.example.testmandatory1.model.CityPostalCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    Random random = new Random();

    @Autowired
    private AddressRepository addressRepository;

    //Address
    public Address generateAddress() {

        List<CityPostalCode> codes = addressRepository.findAll();

        if (codes.isEmpty()) {
            throw new IllegalArgumentException("No city postal codes available");
        }

        CityPostalCode cityCode = codes.get(random.nextInt(codes.size()));


        return new Address(
                generateStreet(),
                generateStreetNumber(),
                generateFloor(),
                generateDoor(),
                cityCode.getCity(),
                cityCode.getCode()
        );
    }

    private String generateStreet() {

        StringBuilder sb = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int length = random.nextInt(3, 31);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }

        return sb.toString();
    }

    private String generateStreetNumber() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int streetNumber = random.nextInt(1, 1000);
        boolean containLetter = random.nextBoolean();

        StringBuilder sb = new StringBuilder();

        sb.append((streetNumber));
        if (containLetter) {
            sb.append(letters.charAt(random.nextInt(letters.length())));
        }

        return sb.toString();
    }

    private String generateFloor() {
        StringBuilder sb = new StringBuilder();
        boolean isGroundFloor = random.nextBoolean();

        if (isGroundFloor) {
            sb.append("st");
        } else {
            sb.append(random.nextInt(1, 100));
        }

        return sb.toString();
    }

    //Door. “th”, “mf”, “tv”, a number from 1 to 50, or a lowercase letter optionally followed by a dash, then followed by one to three numeric digits (e.g., c3, d-14)
    private String generateDoor() {

        StringBuilder sb = new StringBuilder();
        int doorType = random.nextInt(3);

        switch (doorType) {
            case 0:
                List<String> validDoors = Arrays.asList(
                        "th", "mf", "tv");
                sb.append(validDoors.get(random.nextInt(3)));
                break;
            case 1:
                sb.append(random.nextInt(1, 51));
                break;
            case 2:
                String letters = "abcdefghijklmnopqrstuvwxyz";
                sb.append(letters.charAt(random.nextInt(letters.length())));
                boolean hasDash = random.nextBoolean();
                if (hasDash) {
                    sb.append('-');
                }
                sb.append(random.nextInt(1, 1000));
                break;

            default:
                break;
        }

        return sb.toString();
    }

}
