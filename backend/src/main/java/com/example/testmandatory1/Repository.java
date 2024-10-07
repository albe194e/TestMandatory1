package com.example.testmandatory1;


import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<CityPostalCode, String> {

    CityPostalCode findByCode(String code);
}
