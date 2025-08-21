package com.tka.operation.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.tka.config.HibernateConfig;
import com.tka.entity.Product;

public class HqlEx2 {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery(" select id,name,price from Product");
		
		List<Object[]> list = query.list();
		
		for (Object[] obj : list) {
			System.out.print(obj[0]);
			System.out.print(obj[1]);
			System.out.print(obj[2]);
			
			System.out.println();
		}

	}

}
