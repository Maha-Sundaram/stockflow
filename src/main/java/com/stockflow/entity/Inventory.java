package com.stockflow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity

public class Inventory extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	private Integer quantity;
	
	private Integer reorderLevel;
	
	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public Inventory(Product product, Integer quantity, Integer reorderLevel) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.reorderLevel = reorderLevel;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	
}
