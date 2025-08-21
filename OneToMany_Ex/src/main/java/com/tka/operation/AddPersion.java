package com.tka.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tka.config.HibernateConfig;
import com.tka.entity.Persion;

public class AddPersion {
	public static void main(String[] args) {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		
		Persion p=new Persion(2, "bb", 32);

		Transaction tr = session.beginTransaction();
		session.save(p);
		tr.commit();
	}
}
