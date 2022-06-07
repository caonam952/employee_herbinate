package com.caonam.herbinate.feature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.caonam.herbinate.entity.Employee;

public class UpdateEmployee {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			int EmployeeId = 1;
			System.out.println("Update Employee on Id = " + EmployeeId );
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("Update Employee set company ='JJJ' where id = 1 ").executeUpdate();
			System.out.println("After Update: Employee " + session.get(Employee.class, EmployeeId));
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
