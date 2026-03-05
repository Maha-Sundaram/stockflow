package com.stockflow.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.stockflow.dto.PurchaseOrderItemRequestDTO;
import com.stockflow.dto.PurchaseOrderRequestDTO;
import com.stockflow.entity.Product;
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
		
		order.setOrderDate(LocalDate.now());
		
		order.setStatus("CREATED");
		
		List<PurchaseOrderItem> items = new ArrayList<>();
		
		BigDecimal total = BigDecimal.ZERO;
		
		for(PurchaseOrderItemRequestDTO dto : request.getItems()) {
			
			Product product = productRepository.findById(dto.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
			
			PurchaseOrderItem item = new PurchaseOrderItem();
			
			item.setProduct(product);
			
			item.setQuantity(dto.getQuantity());
			
			item.setPrice(dto.getPrice());
			
			item.setPurchaseOrder(order);
			
			BigDecimal itemTotal = dto.getPrice().multiply(BigDecimal.valueOf(dto.getQuantity()));
			
			total = total.add(itemTotal);
			
			items.add(item);
			
		}
		
		order.setItems(items);
		
		order.setTotalAmount(total);
		
		return null;
	}
	
}
