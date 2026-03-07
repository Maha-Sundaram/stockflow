package com.stockflow.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stockflow.dto.PurchaseOrderItemRequestDTO;
import com.stockflow.dto.PurchaseOrderItemResponseDTO;
import com.stockflow.dto.PurchaseOrderRequestDTO;
import com.stockflow.dto.PurchaseOrderResponseDTO;
import com.stockflow.entity.Inventory;
import com.stockflow.entity.Product;
import com.stockflow.entity.PurchaseOrder;
import com.stockflow.entity.PurchaseOrderItem;
import com.stockflow.entity.Vendor;
import com.stockflow.repository.InventoryRepository;
import com.stockflow.repository.ProductRepository;
import com.stockflow.repository.PurchaseOrderRepository;
import com.stockflow.repository.VendorRepository;
import com.stockflow.service.PurchaseOrderService;

@Service

public class PurchaseOrderServiceImpl implements PurchaseOrderService{

	private final PurchaseOrderRepository purchaseOrderRepository;

	private final ProductRepository productRepository;

	private final VendorRepository vendorRepository;

	private final InventoryRepository inventoryRepository;

	public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository, ProductRepository productRepository, VendorRepository vendorRepository, InventoryRepository inventoryRepository) {

		this.purchaseOrderRepository = purchaseOrderRepository;

		this.productRepository = productRepository;

		this.vendorRepository = vendorRepository;

		this.inventoryRepository = inventoryRepository;

	}

	@Override
	public PurchaseOrderResponseDTO createPurchaseOrder(PurchaseOrderRequestDTO request) {

		Vendor vendor = vendorRepository.findById(request.getVendorId()).orElseThrow(() -> new RuntimeException("Vendor not found"));

		PurchaseOrder order = new PurchaseOrder();

		order.setVendor(vendor);

		order.setOrderDate(LocalDate.now());

		order.setStatus("CREATED");

		List<PurchaseOrderItem> items = new ArrayList<>();

		List<PurchaseOrderItemResponseDTO> responseItems = new ArrayList<>();

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

			responseItems.add(new PurchaseOrderItemResponseDTO(product.getName(), dto.getPrice(), dto.getQuantity()));

		}

		order.setItems(items);

		order.setTotalAmount(total);

		PurchaseOrder saveOrder = purchaseOrderRepository.save(order);

		return new PurchaseOrderResponseDTO(saveOrder.getId(), saveOrder.getStatus(), saveOrder.getTotalAmount(), responseItems);
	}

	@Transactional
	public void receivePurchaseOrder(Long orderId) {

		PurchaseOrder order = purchaseOrderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

		if(order.getStatus().equals("RECEIVED")) {

			throw new RuntimeException("Order already received");

		}

		for(PurchaseOrderItem item : order.getItems()) {

			Product product = item.getProduct();

			Inventory inventory = inventoryRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException("Inventory not found"));

			inventory.setQuantity(inventory.getQuantity() + item.getQuantity());

			inventoryRepository.save(inventory);

		}

		order.setStatus("RECEIVED");

		purchaseOrderRepository.save(order);
	}

}
