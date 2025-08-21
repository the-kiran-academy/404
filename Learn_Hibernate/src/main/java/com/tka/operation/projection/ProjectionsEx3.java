package com.tka.operation.projection;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;

import com.tka.config.HibernateConfig;
import com.tka.entity.Product;

public class ProjectionsEx3 {
	public static void main(String[] args) {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Product.class);

		
		PropertyProjection name = Projections.property("name");
		

		criteria.setProjection(name);

		List<String> list = criteria.list();

		for (String n : list) {

			System.out.println(n);
		}

	}
}
