package com.stockflow.dto;

import java.math.BigDecimal;

public class ProductResponseDTO {

	private Long id;
	
	private String name;
	
	private String category;
	
	private BigDecimal price;
	
	private String vendorName;
	

	public ProductResponseDTO(Long id, String name, String category, BigDecimal price, String vendorName) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.vendorName = vendorName;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getVendorName() {
		return vendorName;
	}
	
}
