package com.tka.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Course;
import com.tka.entity.Student;
import com.tka.entity.Student_Course;

public class HibernateConfig {

	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure(); // its locating hibernate.cfg.xml

		cfg.addAnnotatedClass(Course.class);
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Student_Course.class);
		

		SessionFactory sf = cfg.buildSessionFactory();
		return sf;

	}

}
