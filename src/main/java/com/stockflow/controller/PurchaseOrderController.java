package com.stockflow.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.dto.PurchaseOrderRequestDTO;
import com.stockflow.dto.PurchaseOrderResponseDTO;
import com.stockflow.service.PurchaseOrderService;

@RestController
@RequestMapping("/purchase-orders")
public class PurchaseOrderController {

	private PurchaseOrderService purchaseOrderService;
	
	public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}
	
	@PostMapping
	public PurchaseOrderResponseDTO createPurchaseOrder(@RequestBody PurchaseOrderRequestDTO request) {
		return purchaseOrderService.createPurchaseOrder(request);
	}
	
	@PutMapping("/{id}/receive")
	public String recevieOrder(@PathVariable Long id) {
		purchaseOrderService.receivePurchaseOrder(id);
		
		return "Purchase order received successfully";
	}
	
	
}
