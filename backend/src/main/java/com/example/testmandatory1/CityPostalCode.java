package com.example.testmandatory1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CityPostalCode {
    @Id
    private String code;

    @Column
    private String city;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}