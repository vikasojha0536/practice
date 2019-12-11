package com.example.h2Example.modal;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee extends AbstractEntity{

    private String employeeName;

    private String email;

    private Date doj;

    private Double salary;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "address_table",joinColumns = @JoinColumn(name = "employee_id"))
    @GenericGenerator(name = "sequencegen",strategy = "sequence")
    @CollectionId(columns = {@Column(name = "address_id")},generator = "sequencegen",type = @Type(type = "int"))
    private Collection<Address> addressList = new ArrayList<>();

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

    public Collection<Address> getAddressList() {
        return addressList;
    }

    public Employee setAddressList(Collection<Address> addressList) {
        this.addressList = addressList;
        return this;
    }
}
