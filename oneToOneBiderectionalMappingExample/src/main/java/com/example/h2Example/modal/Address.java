package com.example.h2Example.modal;

import javax.persistence.Entity;

@Entity
public class Address extends AbstractEntity {

    private String street, city, country;

    //@OneToOne(mappedBy = "address")
   // private Employee employee;

   // public Employee getEmployee() {
 /*       return employee;
    }

    public Address setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }*/

    public String getStreet() {
        return street;
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
