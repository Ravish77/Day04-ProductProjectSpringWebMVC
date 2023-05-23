package com.telusko.SpringWebProductProject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="place")
	private String place;
	
	@Column(name="warranty")
	private int warranty;
	
	public Product() {
		
	}
	
	public Product(String name, String type, String place, int warranty) {
		super();
		this.name = name;
		this.type = type;
		this.place = place;
		this.warranty = warranty;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", type=" + type + ", place=" + place + ", warranty=" + warranty + "]";
	}

	
	
}
