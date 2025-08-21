package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {
	
	@Id
	private int aid;
	private int acc_num;
	private double balance;
	
	@ManyToOne
	private Persion persion;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(int aid, int acc_num, double balance) {
		super();
		this.aid = aid;
		this.acc_num = acc_num;
		this.balance = balance;
		
	}

	public Account(int aid, int acc_num, double balance, Persion persion) {
		super();
		this.aid = aid;
		this.acc_num = acc_num;
		this.balance = balance;
		this.persion = persion;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getAcc_num() {
		return acc_num;
	}

	public void setAcc_num(int acc_num) {
		this.acc_num = acc_num;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Persion getPersion() {
		return persion;
	}

	public void setPersion(Persion persion) {
		this.persion = persion;
	}
	
	public void display() {
		
		System.out.println("Account ID: " + aid);
		System.out.println("Account Number: " + acc_num);
		System.out.println("Balance: " + balance);
		if (persion != null) {
			System.out.println("Persion ID: " + persion.getPid());
			System.out.println("Persion Name: " + persion.getName());
		} else {
			System.out.println("No associated Persion.");
		}
		System.out.println("-------------------------");
		
		
	}

}
