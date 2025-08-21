package com.tka.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Product;

public class HibernateConfig {
	
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure(); // its locating hibernate.cfg.xml

		cfg.addAnnotatedClass(Product.class);

		SessionFactory sf = cfg.buildSessionFactory();
		return sf; 
		
	}

}
