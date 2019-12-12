package com.example.h2Example.client;

import com.example.h2Example.entities.Employee;
import com.example.h2Example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InsertRecordClientTest {

    public static void main(String[] args) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Employee employee1 = new Employee();
            employee1.setEmployeeName("Sean Murphy");
            employee1.setUsername("seanm");
            employee1.setPassword("pass#123");
            employee1.setAccessLevel(1);

            Employee employee2 = new Employee();
            employee2.setEmployeeName("Barry Johnson");
            employee2.setUsername("barryj");
            employee2.setPassword("barry@123");
            employee2.setAccessLevel(1);

            session.persist(employee1);
            session.persist(employee2);

            tx.commit();

        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            throw e;
        }
    }
}