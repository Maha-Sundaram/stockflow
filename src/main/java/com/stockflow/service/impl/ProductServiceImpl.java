package com.stockflow.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.stockflow.dto.ProductRequestDTO;
import com.stockflow.dto.ProductResponseDTO;
import com.stockflow.entity.Product;
import com.stockflow.entity.Vendor;
import com.stockflow.exception.ResourceNotFoundException;
import com.stockflow.repository.ProductRepository;
import com.stockflow.repository.VendorRepository;
import com.stockflow.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
	
	private final VendorRepository vendorRepository;
	
	public ProductServiceImpl(ProductRepository productRepository, VendorRepository vendorRepository) {
		
		this.productRepository = productRepository;
		this.vendorRepository = vendorRepository;
		
	}
	
	@Override
	public void createProduct(ProductRequestDTO dto) {
		
		Vendor vendor = vendorRepository.findById(dto.getVendorId()).orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
		
		Product product = new Product();
		
		product.setName(dto.getName());
		
		product.setCategory(dto.getCatogery());
		
		product.setPrice(dto.getPrice());
		
		product.setVendor(vendor);
		
		productRepository.save(product);
	}

	@Override
	public Page<ProductResponseDTO> getAllProduct(int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		return productRepository.findAll(pageable).map(this:: mapToDTO);
	}

	@Override
	public Page<ProductResponseDTO> getProductByVendor(Long vendorId, int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		
		return productRepository.findByVendorId(vendorId, pageable).map(this::mapToDTO);
		
	}
	
	private ProductResponseDTO mapToDTO(Product product) {
		return new ProductResponseDTO(product.getId(),
				product.getName(), 
				product.getCategory(), 
				product.getPrice(), 
				product.getVendor().getName());
		
	}
	
}
