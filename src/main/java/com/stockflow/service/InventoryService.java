package com.stockflow.service;

import java.util.List;

import com.stockflow.dto.InventoryRequestDTO;
import com.stockflow.dto.InventoryResponseDTO;

public interface InventoryService {

	InventoryResponseDTO updateStock(InventoryRequestDTO dto);
	
	InventoryResponseDTO getInventoryByProduct(Long productId);
	
	List<InventoryResponseDTO> getLowStockItems();
	
}
