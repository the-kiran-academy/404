package com.tka.operation.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import com.tka.config.HibernateConfig;
import com.tka.entity.Product;

public class LimitEx {

	public static void main(String[] args) {

		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Product.class);
			
		criteria.setMaxResults(2);  // first 2 records
		List<Product> list = criteria.list();

		for (Product product : list) {
			System.out.println(product);
		}

		session.close();

	}

}
