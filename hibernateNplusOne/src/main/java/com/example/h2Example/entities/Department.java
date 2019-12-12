package com.example.h2Example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="dept_name",length=100,nullable=false)
    private String deptName;

    @OneToMany(mappedBy = "department",cascade = CascadeType.PERSIST)
    private List<Employee> employees =  new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Department setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDeptName() {
        return deptName;
    }

    public Department setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Department setEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }
}
