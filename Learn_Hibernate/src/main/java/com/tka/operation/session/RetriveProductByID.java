package com.tka.operation.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tka.config.HibernateConfig;
import com.tka.entity.Product;

public class RetriveProductByID {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateConfig.getSessionFactory();
		
		Session session = sf.openSession();
		
		//Product product = session.load(Product.class, 1);
		Product product = session.get(Product.class, 2);
		
		System.out.println(product);

		session.close();
	}

}
