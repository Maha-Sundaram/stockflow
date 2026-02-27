package com.stockflow.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Product extends BaseEntity{

	private String name;
	
	private String category;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, String category, BigDecimal price, Vendor vendor) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.vendor = vendor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	
}
