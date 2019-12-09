package com.example.springbook;


import com.example.springbook.modal.Product;
import com.example.springbook.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class H2ExampleApplication {


	@Autowired
	private ProductRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(H2ExampleApplication.class, args);
	}
}
