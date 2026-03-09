package com.stockflow.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.stockflow.dto.VendorRequestDTO;
import com.stockflow.dto.VendorResponseDTO;
import com.stockflow.entity.Vendor;
import com.stockflow.exception.ResourceNotFoundException;
import com.stockflow.repository.VendorRepository;
import com.stockflow.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService{

	private VendorRepository vendorRepository;
	
	public VendorServiceImpl(VendorRepository vendorRepository) {
		this.vendorRepository = vendorRepository;
	}
	
	@Override
	public VendorResponseDTO createVendor(VendorRequestDTO dto) {
		Vendor vendor = new Vendor();
				vendor.setName(dto.getName());
				vendor.setEmail(dto.getEmail());
				vendor.setPhone(dto.getPhone());
				vendor.setAddress(dto.getAddress());
		
		Vendor saved = vendorRepository.save(vendor);
		return mapToDTO(saved);
	}

	@Override
	public List<VendorResponseDTO> getAllVendors() {
		return vendorRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public VendorResponseDTO updateVendor(Long id, VendorRequestDTO dto) {
		
		Vendor vendor = vendorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
		vendor.setName(dto.getName());
		vendor.setEmail(dto.getEmail());
		vendor.setPhone(dto.getPhone());
		vendor.setAddress(dto.getAddress());
		return mapToDTO(vendor);
	}

	@Override
	public void deleteVendor(Long id) {
		
		vendorRepository.deleteById(id);
		
	}
	
	private VendorResponseDTO mapToDTO(Vendor vendor) {
		return new VendorResponseDTO(
				vendor.getId(),
				vendor.getName(),
				vendor.getEmail(),
				vendor.getPhone(),
				vendor.getAddress()
				);
	}

}
