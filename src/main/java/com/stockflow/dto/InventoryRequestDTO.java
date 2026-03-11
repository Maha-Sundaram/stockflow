package com.stockflow.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class InventoryRequestDTO {

	@NotNull
	private final Long productId;
	
	
	@NotNull
	@Min(0)
	private final Integer quantity;


	public InventoryRequestDTO(@NotNull Long productId, @NotNull @Min(0) Integer quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}


	public Long getProductId() {
		return productId;
	}


	public Integer getQuantity() {
		return quantity;
	}

}
