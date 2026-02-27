package com.stockflow.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity

public class Vendor extends BaseEntity{

	private String name;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	@OneToMany(mappedBy = "vendor")
	private List<Product> products;
	
	public Vendor() {
		// TODO Auto-generated constructor stub
	}

	public Vendor(String name, String email, String phone, String address, List<Product> products) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
