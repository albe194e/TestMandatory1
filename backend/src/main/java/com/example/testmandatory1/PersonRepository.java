package com.example.testmandatory1;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<CityPostalCode, String> {

    CityPostalCode findByCode(String code);

}
