package com.stockflow.service;

import com.stockflow.dto.PurchaseOrderRequestDTO;
import com.stockflow.dto.PurchaseOrderResponseDTO;

public interface PurchaseOrderService {

	PurchaseOrderResponseDTO createPurchaseOrder(PurchaseOrderRequestDTO request);

	PurchaseOrderResponseDTO receivePurchaseOrder(Long id);
	
}
