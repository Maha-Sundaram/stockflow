
package com.stockflow.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stockflow.dto.InventoryRequestDTO;
import com.stockflow.dto.InventoryResponseDTO;
import com.stockflow.entity.Inventory;
import com.stockflow.exception.InsufficientStockException;
import com.stockflow.exception.ResourceNotFoundException;
import com.stockflow.mapper.InventoryMapper;
import com.stockflow.repository.InventoryRepository;
import com.stockflow.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

	private final InventoryRepository inventoryRepository;
	
	public InventoryServiceImpl(InventoryRepository inventoryRepository) {
		
		this.inventoryRepository = inventoryRepository;
		
	}

	@Override
	public InventoryResponseDTO updateStock(InventoryRequestDTO dto) {
		
		if(dto.getQuantity() < 0) {
			throw new InsufficientStockException("Stock cannot be negative");
		}
		
		Inventory inventory = inventoryRepository.findByProductId(dto.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Inventory not found"));
		
		inventory.setQuantity(inventory.getQuantity());
		
		inventory.setUpdatedAt(LocalDateTime.now());
		
		Inventory saved = inventoryRepository.save(inventory);
		
		return InventoryMapper.toDTO(saved);
	}

	@Override
	public InventoryResponseDTO getInventoryByProduct(Long productId) {
		
		Inventory inventory =  inventoryRepository.findByProductId(productId).orElseThrow(() -> new ResourceNotFoundException("Inventory not found"));
		
		return InventoryMapper.toDTO(inventory);
	}

	@Override
	public List<InventoryResponseDTO> getLowStockItems() {
		return inventoryRepository.findLowStockProducts().stream().map(InventoryMapper :: toDTO).toList();
	}
	
}
