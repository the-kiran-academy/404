package com.tka.operation.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.tka.config.HibernateConfig;
import com.tka.entity.Product;

public class HqlEx3 {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		
		Query<Product> query = session.createQuery("from Product where id= :myid");
		query.setParameter("myid", 3);
		
		List<Product> list = query.list();
		
		for (Product product : list) {
			System.out.println(product);
		}

	}

}
