package com.tka.operation.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tka.config.HibernateConfig;
import com.tka.entity.Product;

public class UpdateProduct {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateConfig.getSessionFactory();

		Session session = sf.openSession();
		
		Product product= new Product(2, "Dell Keyboard", 900, "2022-06-06", "NA", 125, true);
		
		Transaction tr = session.beginTransaction();
		session.update(product);
		tr.commit();
		
		session.close();
		
		
	}

}
