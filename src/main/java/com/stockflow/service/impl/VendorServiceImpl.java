package com.stockflow.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stockflow.dto.VendorRequestDTO;
import com.stockflow.dto.VendorResponseDTO;
import com.stockflow.entity.Vendor;
import com.stockflow.exception.ResourceNotFoundException;
import com.stockflow.mapper.VendorMapper;
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
		
		Vendor vendor = VendorMapper.toEntity(dto);
		
		Vendor saved = vendorRepository.save(vendor);
		
		return VendorMapper.toDTO(saved);
	}

	@Override
	public List<VendorResponseDTO> getAllVendors() {
		
		return vendorRepository.findAll().stream().map(VendorMapper::toDTO).toList();
	}

	@Override
	public VendorResponseDTO updateVendor(Long id, VendorRequestDTO dto) {
		
		Vendor vendor = vendorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
		vendor.setName(dto.getName());
		vendor.setEmail(dto.getEmail());
		vendor.setPhone(dto.getPhone());
		vendor.setAddress(dto.getAddress());
		
		Vendor updateVendor = vendorRepository.save(vendor);
		
		return VendorMapper.toDTO(updateVendor);
	}

	@Override
	public void deleteVendor(Long id) {
		
		Vendor vendor = vendorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
		
		vendorRepository.delete(vendor);
		
	}

}
