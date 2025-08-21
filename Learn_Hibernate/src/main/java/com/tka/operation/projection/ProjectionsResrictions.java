package com.tka.operation.projection;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tka.config.HibernateConfig;
import com.tka.entity.Product;

public class ProjectionsResrictions {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Product.class);
		criteria.setProjection(Projections.max("price"));
		double maxPrice = (double) criteria.uniqueResult();

		Criteria criteria2 = session.createCriteria(Product.class);
		criteria2.add(Restrictions.eq("price", maxPrice));
		List<Product> list = criteria2.list();

		for (Product product : list) {
			System.out.println(product);
		}

	}

}
