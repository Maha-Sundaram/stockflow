package com.stockflow.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public class ProductRequestDTO {

	@NotNull
	private String name;
	
	private String catogery;
	
	@NotNull
	private BigDecimal price;
	
	
	@NotNull
	private Long vendorId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatogery() {
		return catogery;
	}

	public void setCatogery(String catogery) {
		this.catogery = catogery;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	
}
