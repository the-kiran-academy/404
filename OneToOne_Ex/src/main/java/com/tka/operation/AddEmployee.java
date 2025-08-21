package com.tka.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tka.config.HibernateConfig;
import com.tka.entity.Address;
import com.tka.entity.Employee;

public class AddEmployee {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();

		Address address = new Address();
		address.setAid(1);
		
		Employee employee = new Employee(3, "cc", 12345, "HR", address);

		Transaction tr = session.beginTransaction();
		session.save(employee);
		tr.commit();

	}

}
