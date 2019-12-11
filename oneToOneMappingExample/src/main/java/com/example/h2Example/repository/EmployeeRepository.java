package com.example.h2Example.repository;

import com.example.h2Example.modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
