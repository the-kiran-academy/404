package com.tka.operation.restriction;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.tka.config.HibernateConfig;
import com.tka.entity.Product;

public class RestrictionEx1 {

	public static void main(String[] args) {

		SessionFactory sf = HibernateConfig.getSessionFactory();

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Product.class);
		
		criteria.add(Restrictions.eq("name", "pen"));

		//criteria.add(Restrictions.and(Restrictions.eq("price", 500d),Restrictions.eq("qty", 150)));

		List<Product> p = criteria.list();

		for (Product product : p) {
			System.out.println(product);
		}

	}

}
