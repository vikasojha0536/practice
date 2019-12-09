package com.example.springbook.repository;

import com.example.springbook.modal.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByDescriptionContaining(String description, Pageable pageable);
}
