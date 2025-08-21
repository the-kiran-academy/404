package com.tka.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tka.config.HibernateConfig;
import com.tka.entity.Address;

public class AddAddress {
	public static void main(String[] args) {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();

		Address address = new Address(2, "warje", "Haveli", "Pune", "MH");
		

		Transaction tr = session.beginTransaction();
		session.save(address);
		tr.commit();

	}
}
