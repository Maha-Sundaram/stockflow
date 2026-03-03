package com.stockflow.service;

import java.util.List;

import com.stockflow.entity.Inventory;

public interface InventoryService {

	Inventory updateStock(Long productId, Integer newQuantity);
	
	Inventory getIventoryByProduct(Long productId);
	
	List<Inventory> getLowStockItems();
	
}
