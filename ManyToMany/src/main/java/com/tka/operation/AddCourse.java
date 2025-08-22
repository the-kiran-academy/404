package com.tka.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tka.config.HibernateConfig;
import com.tka.entity.Course;

public class AddCourse {
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateConfig.getSessionFactory();
		
		Session session= sf.openSession();
		
		Course course=new Course("React", 25000d);
		
		Transaction tr = session.beginTransaction();
		session.save(course);
		tr.commit();
	}

}
