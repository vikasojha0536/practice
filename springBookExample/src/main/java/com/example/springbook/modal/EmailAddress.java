package com.example.springbook.modal;

public class EmailAddress {
    private String value;

    public String getValue() {
        return value;
    }

    public EmailAddress setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return value;
    }
}
