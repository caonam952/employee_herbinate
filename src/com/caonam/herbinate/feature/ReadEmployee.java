package com.caonam.herbinate.feature;

import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.caonam.herbinate.entity.Employee;

public class ReadEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int EmployeeId = 1;
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Get Employee on id = " + EmployeeId);
			
			Employee ep1 = session.get(Employee.class, EmployeeId);
			
			System.out.println("Employee on id = " + EmployeeId + ":" + ep1 );
			
			session.getTransaction().commit();
			
			System.out.println("done");
		} finally {
			factory.close();
		}
	}

}
