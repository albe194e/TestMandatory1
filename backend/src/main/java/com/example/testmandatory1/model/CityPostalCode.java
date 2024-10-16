package com.example.testmandatory1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class CityPostalCode {
    @Id
    private String code;

    @Column
    private String city;

    public CityPostalCode() {

    }
}
