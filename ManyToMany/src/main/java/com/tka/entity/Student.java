package com.tka.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String name;
	private int age;
	
	@ManyToMany
	@JoinTable(
	    name = "student_course",
	    joinColumns = @JoinColumn(name = "sid"),
	    inverseJoinColumns = @JoinColumn(name = "cid")
	)
	private List<Course> courses;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String name, int age, List<Course> courses) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.courses = courses;
	}

	public Student(String name, int age, List<Course> courses) {
		super();
		this.name = name;
		this.age = age;
		this.courses = courses;
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void display() {
		System.out.println("Student ID: " + sid);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		if (courses != null && !courses.isEmpty()) {
			System.out.println("Courses: ");
			for (Course course : courses) {
				System.out.println(" - " + course.getName());
			}
		} else {
			System.out.println("No courses enrolled.");
		}
	}
	

}
