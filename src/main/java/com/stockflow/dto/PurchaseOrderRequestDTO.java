package com.stockflow.dto;

import java.util.List;

public class PurchaseOrderRequestDTO {

	private Long vendorId;
	
	private List<PurchaseOrderItemRequestDTO> items;

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public List<PurchaseOrderItemRequestDTO> getItems() {
		return items;
	}

	public void setItems(List<PurchaseOrderItemRequestDTO> items) {
		this.items = items;
	}
	
}
