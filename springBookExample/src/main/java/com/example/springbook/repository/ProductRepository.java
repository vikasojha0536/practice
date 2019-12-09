package com.example.springbook.repository;

import com.example.springbook.modal.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByDescriptionContaining(String description, Pageable pageable);

    @Query("select p from Product p where p.attributes[?1] = ?2")
    List<Product> findByAttributeAndValue(String attribute, String value);

}
