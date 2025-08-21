package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	private int aid;
	private String village;
	private String taluka;
	private String dist;
	private String state;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int aid, String village, String taluka, String dist, String state) {
		super();
		this.aid = aid;
		this.village = village;
		this.taluka = taluka;
		this.dist = dist;
		this.state = state;
	}

	public Address(String village, String taluka, String dist, String state) {
		super();
		this.village = village;
		this.taluka = taluka;
		this.dist = dist;
		this.state = state;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void dispaly() {

		System.out.println("Address [aid=" + aid + ", village=" + village + ", taluka=" + taluka + ", dist=" + dist
				+ ", state=" + state + "]");
	}

}
