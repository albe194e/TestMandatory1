package com.example.testmandatory1.integrationtest;

import com.example.testmandatory1.model.Address;
import com.example.testmandatory1.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void testDisplayRandomAddress() throws IllegalArgumentException {
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

}
