package com.stockflow.service;

import com.stockflow.dto.PurchaseOrderRequestDTO;
import com.stockflow.entity.PurchaseOrder;

public interface PurchaseOrderService {

	PurchaseOrder createPurchaseOrder(PurchaseOrderRequestDTO request);
	
}
