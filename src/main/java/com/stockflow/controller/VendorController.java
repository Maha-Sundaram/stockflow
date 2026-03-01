package com.stockflow.controller;

import java.util.List;

import org.hibernate.dialect.function.AvgFunction.ReturnTypeResolver;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.dto.VendorRequestDTO;
import com.stockflow.dto.VendorResponseDTO;
import com.stockflow.service.VendorService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/vendors")
public class VendorController {

	private final VendorService vendorService;
	
	public VendorController(VendorService vendorService) {
		this.vendorService = vendorService;
	}
	
	@PostMapping
	public VendorResponseDTO createVendor(@Valid @RequestBody VendorRequestDTO dto) {
		return vendorService.createVendor(dto);
	}
	
	@GetMapping
	public List<VendorResponseDTO> getAllVendors() {
		return vendorService.getAllVendors();
	}
	
	@PutMapping("/{id}")
	public VendorResponseDTO updateVendor(@PathVariable Long id, @Valid @RequestBody VendorRequestDTO dto) {
		return vendorService.updateVendor(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteVendor(@PathVariable Long id) {
		vendorService.deleteVendor(id);
	}
}
