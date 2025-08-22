package com.tka.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persion {

	@Id
	private int pid;
	private String name;
	private int age;
	
	@OneToMany(mappedBy = "persion")
	private List<Account> accounts;

	public Persion() {
		// TODO Auto-generated constructor stub
	}

	public Persion(int pid, String name, int age, List<Account> accounts) {
		super();
		this.pid = pid;
		this.name = name;
		this.age = age;
		this.accounts = accounts;
	}

	

	public Persion(int pid, String name, int age) {
		super();
		this.pid = pid;
		this.name = name;
		this.age = age;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void display() {
		
		
		System.out.println("Persion [pid=" + pid + ", name=" + name + ", age=" + age + "]");

		if (accounts != null && !accounts.isEmpty()) {
			System.out.println("Accounts:");
			for (Account account : accounts) {
				account.display();
			}
		} else {
			System.out.println("No accounts associated with this persion.");
		}
		

	}
	
}
