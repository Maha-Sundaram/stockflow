package com.stockflow.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.dto.PurchaseOrderRequestDTO;
import com.stockflow.entity.PurchaseOrder;

@RestController
@RequestMapping("/purchase-orders")
public class PurchaseOrderController {

	private PurchaseOrderController purchaseOrderService;
	
	public PurchaseOrderController(PurchaseOrderController purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}
	
	@PostMapping
	public PurchaseOrder createOrder(@RequestBody PurchaseOrderRequestDTO request) {
		return purchaseOrderService.createPurchaseOrder(request);
	}
	
	
}
