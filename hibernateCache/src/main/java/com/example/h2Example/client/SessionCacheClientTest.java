package com.example.h2Example.client;

import com.example.h2Example.entities.Employee;
import com.example.h2Example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionCacheClientTest {

    public static void main(String[] args) throws Exception {
       // sesionCacheForInsertRecord();
        //sesionCacheReadByPrimaryKey();
        sesionCacheReadByNaturalId();
        //sesionCacheForUpdateRecord();
       // sesionCacheForDeleteRecord();
    }

    private static void sesionCacheForDeleteRecord() {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long employeeId = 2L;
            Employee employee1 = session.get(Employee.class, employeeId);
            System.out.println(employee1);
            if (employee1 != null) {
                tx = session.beginTransaction();
                session.delete(employee1);
                tx.commit();
            }
            System.out.println("-------------------------------------------------------------");
            Employee employee2 = session.get(Employee.class, employeeId);
            System.out.println(employee2);
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            throw e;
        }
    }

    private static void sesionCacheForUpdateRecord() {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long employeeId = 1L;
            String newPassword = "password$23";
            Employee employee1 = session.get(Employee.class, employeeId);
            System.out.println(employee1);
            if (employee1 != null) {
                tx = session.beginTransaction();
                employee1.setPassword(newPassword);
                tx.commit();
            }
            System.out.println("-------------------------------------------------------------");
            Employee employee2 = session.get(Employee.class, employeeId);
            System.out.println(employee2);
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            throw e;
        }

    }

    private static void sesionCacheReadByNaturalId() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String username = "janetj";

            Employee employee1 = session.bySimpleNaturalId(Employee.class).load(username);
            System.out.println(employee1);

            System.out.println("-------------------------------------------------------------");
            Employee employee2 = session.bySimpleNaturalId(Employee.class).load(username);
            System.out.println(employee2);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void sesionCacheReadByPrimaryKey() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long employeeId = 1L;
            Employee employee1 = session.get(Employee.class, employeeId);
            System.out.println(employee1);

            System.out.println("-------------------------------------------------------------");
            Employee employee2 = session.get(Employee.class, employeeId);
            System.out.println(employee2);
        } catch (Exception e) {
            throw e;
        }
    }

    private static void sesionCacheForInsertRecord() {

        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = new Employee();
            employee.setEmployeeName("Janet Johnson");
            employee.setUsername("janetj");
            employee.setPassword("janet#123");
            employee.setAccessLevel(1);

            tx = session.beginTransaction();
            Long employeeId = (Long) session.save(employee);

            tx.commit();
            System.out.println("-------------------------------------------------------------");
            Employee employee2 = session.get(Employee.class, employeeId);
            System.out.println(employee2);
        } catch (Exception e) {
            if (tx != null && tx.isActive())
                tx.rollback();
            throw e;
        }
    }
}
