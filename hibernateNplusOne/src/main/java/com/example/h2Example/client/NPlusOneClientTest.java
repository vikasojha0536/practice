package com.example.h2Example.client;

import com.example.h2Example.entities.Department;
import com.example.h2Example.entities.Employee;
import com.example.h2Example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class NPlusOneClientTest {

	public static void main(String[] args) throws Exception {

			try (Session session = HibernateUtil.getSessionFactory().openSession()) {

				List<Department> departments = session.createQuery("From Department d JOIN fetch d.employees", Department.class).getResultList();

				for (Department department : departments) {
					System.out.println("Department details:::::");

					System.out.println(department.getId()+"\t"+department.getDeptName());
					List<Employee> employees = department.getEmployees();
					System.out.println("Employees details::::::");
					for (Employee employee : employees) {

						System.out.println(employee.getId() + "\t" + employee.getEmployeeName() + "\t" + employee.getUsername()
								+ "\t" + employee.getPassword() + "\t" + employee.getAccessLevel());
					}

				}
			}
	}
}