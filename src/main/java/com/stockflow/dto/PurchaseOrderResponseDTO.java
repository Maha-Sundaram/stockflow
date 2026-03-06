package com.stockflow.dto;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseOrderResponseDTO {

	private Long id;
	
	private String status;
	
	private BigDecimal totalAmount;
	
	private List<PurchaseOrderItemResponseDTO> items;

	public PurchaseOrderResponseDTO(Long id, String status, BigDecimal totalAmount,
			List<PurchaseOrderItemResponseDTO> items) {
		super();
		this.id = id;
		this.status = status;
		this.totalAmount = totalAmount;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public List<PurchaseOrderItemResponseDTO> getItems() {
		return items;
	}
	
}
