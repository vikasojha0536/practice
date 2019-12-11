package com.example.h2Example;

import com.example.h2Example.modal.Address;
import com.example.h2Example.modal.Employee;
import com.example.h2Example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OneToOneExampleApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneExampleApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Address address = new Address().setCity("delhi");
		 employeeRepository.save(new Employee().setEmail("ojhavikas0536@gmail.com").setAddress(address));
		List<Employee> all = employeeRepository.findAll();
		all.forEach(System.out::println);
	}
}
