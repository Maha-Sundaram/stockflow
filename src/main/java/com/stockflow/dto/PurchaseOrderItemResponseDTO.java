package com.stockflow.dto;

import java.math.BigDecimal;

public class PurchaseOrderItemResponseDTO {

private String product;
	
	private BigDecimal price;
	
	private int quantity;

	public PurchaseOrderItemResponseDTO(String product, BigDecimal price, int quantity) {
		super();
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public String getProduct() {
		return product;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
}
