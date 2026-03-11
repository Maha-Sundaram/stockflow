package com.stockflow.mapper;

import com.stockflow.dto.InventoryResponseDTO;
import com.stockflow.entity.Inventory;

public class InventoryMapper {

	public static InventoryResponseDTO toDTO(Inventory inventory) {
		
		return new InventoryResponseDTO(
				
				inventory.getId(),
				inventory.getProduct().getId(),
				inventory.getProduct().getName(),
				inventory.getQuantity(),
				inventory.getUpdatedAt()
				
				);
		
	}
	
}
