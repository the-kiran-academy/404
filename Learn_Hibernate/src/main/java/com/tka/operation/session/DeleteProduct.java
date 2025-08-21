package com.tka.operation.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tka.config.HibernateConfig;
import com.tka.entity.Product;

public class DeleteProduct {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfig.getSessionFactory();

		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();

		Product product = session.get(Product.class, 2);

		session.delete(product);
		tr.commit();
		
		session.close();

	}

}
