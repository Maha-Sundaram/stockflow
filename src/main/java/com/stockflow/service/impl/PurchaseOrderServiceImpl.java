package com.stockflow.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.stockflow.dto.PurchaseOrderRequestDTO;
import com.stockflow.entity.PurchaseOrder;
import com.stockflow.entity.PurchaseOrderItem;
import com.stockflow.entity.Vendor;
import com.stockflow.repository.ProductRepository;
import com.stockflow.repository.PurchaseOrderRepository;
import com.stockflow.repository.VendorRepository;
import com.stockflow.service.PurchaseOrderService;

public class PurchaseOrderServiceImpl implements PurchaseOrderService{

	private final PurchaseOrderRepository purchaseOrderRepository;
	
	private final ProductRepository productRepository;
	
	private final VendorRepository vendorRepository;
	
	public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository, ProductRepository productRepository, VendorRepository vendorRepository) {
		
		this.purchaseOrderRepository = purchaseOrderRepository;
		
		this.productRepository = productRepository;
		
		this.vendorRepository = vendorRepository;
		
	}
	
	@Override
	public PurchaseOrder createPurchaseOrder(PurchaseOrderRequestDTO request) {
		
		Vendor vendor = vendorRepository.findById(request.getVendorId()).orElseThrow(() -> new RuntimeException("Vendor not found"));
		
		PurchaseOrder order = new PurchaseOrder();
		
		order.setVendor(vendor);
		
		order.setOrderDatl]''(LocalDate.now());
		
		order.setStatus("CREATED");
		
		List<PurchaseOrderItem> items = new ArrayList<>();
		
		BigDecimal total = BigDecimal.ZERO;
		
		for(CreatePurchaseOrderItemDTO dto : request.getItems()) {
			
			
			
		}
		
		return null;
	}
	
}
