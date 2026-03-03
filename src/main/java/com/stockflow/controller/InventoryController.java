package com.stockflow.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.entity.Inventory;
import com.stockflow.service.InventoryService;

@RestController
@RequestMapping("/inventory")

public class InventoryController {

	private final InventoryService inventoryService;
	
	public InventoryController(InventoryService inventoryService) {
		
		this.inventoryService = inventoryService;
		
	}
	
	@PutMapping("/update-stock")
	public Inventory updateStock(@RequestParam Long productId, @RequestParam Integer quantity) {
		
		return inventoryService.updateStock(productId, quantity);
	}
	
	@GetMapping("/product/{id}")
	public Inventory getInventory(@PathVariable Long id) {
		
		return inventoryService.getIventoryByProduct(id);
		
	}
	
	@GetMapping("/low-stock")
	public List<Inventory> getLowStock() {
		return inventoryService.getLowStockItems();
	}
	
}
