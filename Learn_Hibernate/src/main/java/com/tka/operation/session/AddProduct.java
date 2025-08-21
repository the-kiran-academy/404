package com.tka.operation.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tka.config.HibernateConfig;
import com.tka.entity.Product;

public class AddProduct {
	public static void main(String[] args) {

		SessionFactory sf = HibernateConfig.getSessionFactory();

		Session session = sf.openSession();

		Product product = new Product("fan", 5500d, "2023-06-06", "NA", 50, true);
		Transaction tr = session.beginTransaction();
		session.save(product);
		tr.commit();
		session.close();

	}

}
