package com.example.testmandatory1.integrationtest;

import com.example.testmandatory1.model.Address;
import com.example.testmandatory1.model.CityPostalCode;
import com.example.testmandatory1.repository.AddressRepository;
import com.example.testmandatory1.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void testDisplayRandomAddress() throws IllegalArgumentException {
        // Act
        Address address = addressService.generateAddress();

        // Assert
        assertNotNull(address);
        assertNotNull(address.getStreet());
        assertNotNull(address.getNumber());
        assertNotNull(address.getFloor());
        assertNotNull(address.getDoor());
        assertNotNull(address.getCity());
        assertNotNull(address.getPostalCode());

    }

    @Test
    void testCityPostalCodeDataLoaded() {
        List<CityPostalCode> codes = addressRepository.findAll();
        assertFalse(codes.isEmpty(), "City postal codes should not be empty after initialization.");
    }


}
