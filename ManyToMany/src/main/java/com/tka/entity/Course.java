package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String name;
	private double fees;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int cid, String name, double fees) {
		super();
		this.cid = cid;
		this.name = name;
		this.fees = fees;
	}

	public Course(String name, double fees) {
		super();
		this.name = name;
		this.fees = fees;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
	
	public void display() {
		
		System.out.println("Course ID: " + cid);
		System.out.println("Course Name: " + name);
		System.out.println("Course Fees: " + fees);
		System.out.println("-------------------------------");
		
	}
}
