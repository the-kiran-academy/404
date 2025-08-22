package com.tka.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tka.config.HibernateConfig;
import com.tka.entity.Student;

public class AddStudent {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session = sf.openSession();
		
		Student student=new Student("CC", 25);
		
		Transaction tr = session.beginTransaction();
		session.save(student);
		tr.commit();

	}

}
