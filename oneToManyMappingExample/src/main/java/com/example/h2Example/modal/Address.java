package com.example.h2Example.modal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Address extends AbstractEntity{

    private String street, city, country;

    public String getStreet() {
        return street;
    }

    @ManyToOne
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public Address setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }
}
