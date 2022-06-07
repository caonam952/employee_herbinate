package com.caonam.herbinate.feature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.caonam.herbinate.entity.Employee;

public class DeleteEmployee {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int EmployeeId = 1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Delete Employee on id = " + EmployeeId);
			
			Employee ep1 = session.get(Employee.class, EmployeeId);
			session.delete(ep1);
			
			session.getTransaction().commit();
		} finally {
			
		}
		
	}
}
