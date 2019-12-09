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
public class H2ExampleApplication implements CommandLineRunner {


	@Autowired
	private ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(H2ExampleApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Product product = new Product().setName("Camera bag").setPrice(new BigDecimal("49.99"));

		product = repository.save(product);
	}
}
