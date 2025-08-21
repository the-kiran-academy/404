package com.tka.operation.projection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.tka.config.HibernateConfig;
import com.tka.entity.Product;

public class ProjectionEx {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		
		// session criteria restrictions Projections
		
		// for aggregate function we need to use Projections
		
		Criteria criteria = session.createCriteria(Product.class);
		
		criteria.setProjection(Projections.avg("price"));
		
		double result = (double) criteria.uniqueResult();
		
		System.out.println(result);
		

	}

}
