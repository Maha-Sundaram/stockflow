package com.stockflow.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.stockflow.dto.PurchaseOrderItemResponseDTO;
import com.stockflow.dto.PurchaseOrderResponseDTO;
import com.stockflow.entity.PurchaseOrder;
import com.stockflow.entity.PurchaseOrderItem;

public class PurchaseOrderMapper {

	public static PurchaseOrderResponseDTO toDTO(PurchaseOrder order) {
		
		List<PurchaseOrderItemResponseDTO> items = order.getItems().stream().map(PurchaseOrderMapper :: mapItem).collect(Collectors.toList());
	
		return new PurchaseOrderResponseDTO(
				
				order.getId(),order.getStatus(),order.getTotalAmount(),items
				
				);
		
	}
	
	private static PurchaseOrderItemResponseDTO mapItem(PurchaseOrderItem item) {
		
		return new PurchaseOrderItemResponseDTO(
				
				item.getId(),
				item.getProduct().getId(),
				item.getProduct().getName(),
				item.getPrice(),
				item.getQuantity()
				);
		
	}
	
	
}
