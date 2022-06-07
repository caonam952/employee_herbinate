package com.caonam.herbinate.feature;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.caonam.herbinate.entity.Employee;


public class ReadEmployee2 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Show all employee on JJJ company!!");
			
			List<Employee> employeeList = session.createQuery("from Employee").getResultList();
			
			employeeList = session.createQuery("from Employee e where e.company ='JJJ'").getResultList();
			
			for(Employee e: employeeList) {
				System.out.println(e);
			}
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
