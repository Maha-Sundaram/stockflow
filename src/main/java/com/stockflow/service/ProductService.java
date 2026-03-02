package com.stockflow.service;

import org.springframework.data.domain.Page;

import com.stockflow.dto.ProductRequestDTO;
import com.stockflow.dto.ProductResponseDTO;

public interface ProductService {

	void createProduct(ProductRequestDTO dto);
	
	Page<ProductResponseDTO> getAllProduct(int page,int size);
	
	
	Page<ProductResponseDTO> getProductByVendor(Long vendorId, int page, int size);
	
}
