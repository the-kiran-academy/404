package com.tka.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tka.config.HibernateConfig;
import com.tka.entity.Persion;

public class RetrivePersion {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		
		Persion persion = session.get(Persion.class, 1);
		
		persion.display();
		

	}

}
