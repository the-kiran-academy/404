package com.tka.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tka.config.HibernateConfig;
import com.tka.entity.Course;
import com.tka.entity.Student;
import com.tka.entity.Student_Course;

public class AssignStudentCourse {

	public static void main(String[] args) {

		SessionFactory sf = HibernateConfig.getSessionFactory();

		Session session = sf.openSession();

		Student student = new Student();
		student.setSid(2);

		Course course = new Course();
		course.setCid(3);

		Student_Course sc = new Student_Course(student, course);

		Transaction tr = session.beginTransaction();

		session.save(sc);
		tr.commit();

	}

}
