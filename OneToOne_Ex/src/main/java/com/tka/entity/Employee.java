package com.tka.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	@Id
	private int eid;
	private String name;
	private double salary;
	private String department;
	
	@OneToOne
	private Address address;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String name, double salary, String department, Address address) {
		super();
		this.eid = eid;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.address = address;
	}

	public Employee(String name, double salary, String department, Address address) {
		super();
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.address = address;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void display() {
		System.out.println("EID: " + eid);
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);
		System.out.println("Department: " + department);
		System.out.println("Address: " +address);
		System.out.println("-----------------------");
	}

}
