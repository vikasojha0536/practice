package com.example.h2Example.modal;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee extends AbstractEntity {

    private String employeeName;

    private String email;

    private Date doj;

    private Double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;

    public String getEmployeeName() {
        return employeeName;
    }

    public Employee setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getDoj() {
        return doj;
    }

    public Employee setDoj(Date doj) {
        this.doj = doj;
        return this;
    }

    public Double getSalary() {
        return salary;
    }

    public Employee setSalary(Double salary) {
        this.salary = salary;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Employee setAddress(Address address) {
        this.address = address;
        return this;
    }
}
