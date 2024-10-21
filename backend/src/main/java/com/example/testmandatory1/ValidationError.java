package com.example.testmandatory1;

import lombok.Getter;

@Getter
public class ValidationError {
    private String message;

    public ValidationError(String message) {
        this.message = message;
    }

}
