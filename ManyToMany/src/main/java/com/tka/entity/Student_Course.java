package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_course")
public class Student_Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "sid")
	private Student sid;
	
	@ManyToOne
	@JoinColumn(name = "cid")
	private Course cid;
	
	public Student_Course() {
		// TODO Auto-generated constructor stub
	}

	public Student_Course(Student sid, Course cid) {
		super();
		this.sid = sid;
		this.cid = cid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getSid() {
		return sid;
	}

	public void setSid(Student sid) {
		this.sid = sid;
	}

	public Course getCid() {
		return cid;
	}

	public void setCid(Course cid) {
		this.cid = cid;
	}

	
	


}
