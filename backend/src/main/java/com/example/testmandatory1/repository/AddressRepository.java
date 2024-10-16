package com.example.testmandatory1.repository;


import com.example.testmandatory1.model.CityPostalCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<CityPostalCode, String> {

    CityPostalCode findByCode(String code);

}
