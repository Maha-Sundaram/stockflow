package com.stockflow.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.dto.ProductRequestDTO;
import com.stockflow.dto.ProductResponseDTO;
import com.stockflow.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping
	public String createProduct(@Valid @RequestBody ProductRequestDTO dto) {
		
		productService.createProduct(dto);
		
		return "Product Created Successfully";

	}
	
	@GetMapping
	public Page<ProductResponseDTO> getProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
		
		return productService.getAllProduct(page, size);
		
	}
	
	@GetMapping("/{id}")
	public ProductResponseDTO getProduct(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/vendor/{vendorId}")
	public Page<ProductResponseDTO> getByVendor(@PathVariable Long vendorId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size
			) {
		
		return productService.getProductByVendor(vendorId, page, size);
		
	}
	
}
