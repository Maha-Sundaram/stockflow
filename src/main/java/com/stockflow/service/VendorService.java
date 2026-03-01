package com.stockflow.service;

import java.util.List;

import com.stockflow.dto.VendorRequestDTO;
import com.stockflow.dto.VendorResponseDTO;

public interface VendorService {

	VendorResponseDTO createVendor(VendorRequestDTO dto);
	
	List<VendorResponseDTO> getAllVendors();
	
	VendorResponseDTO updateVendor(
			Long id, VendorRequestDTO dto );
	
	void deleteVendor(Long id);
	
}
