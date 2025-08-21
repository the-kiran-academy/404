package com.tka.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tka.config.HibernateConfig;
import com.tka.entity.Account;
import com.tka.entity.Persion;

public class AddAccount {

	public static void main(String[] args) {

		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		
		Persion persion=new Persion();
		persion.setPid(2);

		Account account = new Account(102, 22223344, 500d,persion);

		Transaction tr = session.beginTransaction();
		session.save(account);
		tr.commit();

	}

}
