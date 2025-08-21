package com.tka.operation.session;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tka.config.HibernateConfig;
import com.tka.entity.Product;

public class RetriveProductsByMultipleIds {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateConfig.getSessionFactory();

		Session session = sf.openSession();
		
		List<Product> list = session.byMultipleIds(Product.class).multiLoad(1,3,4);
		
		for (Product product : list) {
			System.out.println(product);
		}

		
		session.close();

	}

}
