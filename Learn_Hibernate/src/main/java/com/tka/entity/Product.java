package com.tka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "id", nullable = false,unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name",unique = true,nullable = false)
	private String name;
	
	@Column(name = "product_price",unique = false,nullable = false)
	private double price;
	
	@Column(name = "mfg_date",unique = false,nullable = false)
	private String mfgDate;
	
	@Column(name = "exp_date",unique = false,nullable = false)
	private String expDate="NA";
	
	@Column(name = "qty",unique = false,nullable = false)
	private int qty;
	
	@Column(name = "is_in_stock",unique = false,nullable = false)
	private boolean isInStock;

	public Product() {
		
	}
	
	
	public Product(String name, double price, String mfgDate, String expDate, int qty, boolean isInStock) {
		super();
		this.name = name;
		this.price = price;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.qty = qty;
		this.isInStock = isInStock;
	}


	public Product(int id, String name, double price, String mfgDate, String expDate, int qty, boolean isInStock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.qty = qty;
		this.isInStock = isInStock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public boolean isInStock() {
		return isInStock;
	}

	public void setInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", mfgDate=" + mfgDate + ", expDate="
				+ expDate + ", qty=" + qty + ", isInStock=" + isInStock + "]";
	}

}
