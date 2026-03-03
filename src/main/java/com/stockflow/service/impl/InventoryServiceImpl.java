package com.stockflow.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stockflow.entity.Inventory;
import com.stockflow.exception.InsufficientStockException;
import com.stockflow.repository.InventoryRepository;
import com.stockflow.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

	private final InventoryRepository inventoryRepository;
	
	public InventoryServiceImpl(InventoryRepository inventoryRepository) {
		
		this.inventoryRepository = inventoryRepository;
		
	}

	@Override
	public Inventory updateStock(Long productId, Integer newQuantity) {
		
		if(newQuantity < 0) {
			throw new InsufficientStockException("Stock cannot be negative");
		}
		
		Inventory inventory = inventoryRepository.findByProductId(productId).orElseThrow(() -> new RuntimeException("Inventory not found"));
		
		inventory.setQuantity(newQuantity);
		
		inventory.setUpdatedAt(LocalDateTime.now());
		
		return inventoryRepository.save(inventory);
	}

	@Override
	public Inventory getIventoryByProduct(Long productId) {
		
		return inventoryRepository.findByProductId(productId).orElseThrow(() -> new RuntimeException("Inventory not found"));
	}

	@Override
	public List<Inventory> getLowStockItems() {
		return inventoryRepository.findLowStockProducts();
	}
	
}
