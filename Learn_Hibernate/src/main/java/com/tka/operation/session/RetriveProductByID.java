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
		Product product1 = session.get(Product.class, 1);
		
		System.out.println("product 1: "+product1);
		
		
		Session session2 = sf.openSession();
		Product product2 = session2.get(Product.class, 1);
		
		System.out.println("product 2: "+product2);

		session.close();
	}

}
