package com.example.h2Example;

import com.example.h2Example.modal.Employee;
import com.example.h2Example.repository.EmployeeRepository;
import com.example.h2Example.repository.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateCacheExample implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateCacheExample.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Transaction tx =  null;
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			tx = session.beginTransaction();

			Employee employee1 = new Employee();
			employee1.setEmployeeName("Sean Murphy");


			Employee employee2 = new Employee();
			employee2.setEmployeeName("Barry Johnson");


			session.persist(employee1);
			session.persist(employee2);

			tx.commit();

		} catch (Exception e) {
			if(tx != null && tx.isActive())
				tx.rollback();
			throw e;
		}
	}
}
