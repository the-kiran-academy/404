package com.tka.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tka.config.HibernateConfig;
import com.tka.entity.Employee;

public class RetriveEmployee {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		
		Employee employee = session.get(Employee.class, 1);
		
		employee.display();
		

	}

}
