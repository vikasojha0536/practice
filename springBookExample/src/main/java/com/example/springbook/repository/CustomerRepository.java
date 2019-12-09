package com.example.springbook.repository;

import com.example.springbook.modal.Customer;
import com.example.springbook.modal.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmailAddress(EmailAddress emailAddress);
}
