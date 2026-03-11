package com.stockflow.dto;

import java.time.LocalDateTime;

public class InventoryResponseDTO {

	private final Long id;
	
	private final Long productId;
	
	private final String productName;
	
	private final Integer quantity;
	
	private final LocalDateTime updatedAt;
	

	public InventoryResponseDTO(Long id, Long productId, String productName, Integer quantity,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public Long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
}
