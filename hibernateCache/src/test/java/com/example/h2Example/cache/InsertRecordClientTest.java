package com.example.h2Example.cache;

import com.example.h2Example.modal.Employee;
import com.example.h2Example.repository.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class InsertRecordClientTest {

	public static void main(String[] args) {
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