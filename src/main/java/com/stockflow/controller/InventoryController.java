package com.stockflow.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.dto.InventoryRequestDTO;
import com.stockflow.dto.InventoryResponseDTO;
import com.stockflow.service.InventoryService;

@RestController
@RequestMapping("/inventory")

public class InventoryController {

	private final InventoryService inventoryService;
	
	public InventoryController(InventoryService inventoryService) {
		
		this.inventoryService = inventoryService;
		
	}
	
	@PutMapping("/update-stock")
	public InventoryResponseDTO updateStock(@RequestBody InventoryRequestDTO dto) {
		
		return inventoryService.updateStock(dto);
	}
	
	@GetMapping("/product/{id}")
	public InventoryResponseDTO getInventory(@PathVariable Long id) {
		
		return inventoryService.getInventoryByProduct(id);
		
	}
	
	@GetMapping("/low-stock")
	public List<InventoryResponseDTO> getLowStock() {
		return inventoryService.getLowStockItems();
	}
	
}
