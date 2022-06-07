package com.caonam.herbinate.feature;

import org.hibernate.cfg.Configuration;

import com.caonam.herbinate.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class CreateEmpoyee {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Create Employee");
			Employee ep1 = new Employee("JJJ","UUU","dja");
			
			Employee ep2 = new Employee("JYJ","GUU","JJJ");
			
			Employee ep3 = new Employee("JPJ","OUU","dyya");
			

			session.beginTransaction();
			
			session.save(ep1);
			System.out.println(ep1.getId());
			session.save(ep2);
			System.out.println(ep2.getId());
			session.save(ep3);
			System.out.println(ep3.getId());
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
