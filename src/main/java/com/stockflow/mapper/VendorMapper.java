package com.stockflow.mapper;

import com.stockflow.dto.VendorRequestDTO;
import com.stockflow.dto.VendorResponseDTO;
import com.stockflow.entity.Vendor;

public class VendorMapper {

	public static Vendor toEntity(VendorRequestDTO dto) {
		
		Vendor vendor = new Vendor();
		
		vendor.setName(dto.getName());
		
		vendor.setEmail(dto.getEmail());
		
		vendor.setPhone(dto.getPhone());
		
		vendor.setAddress(dto.getAddress());
		
		return vendor;
		
	}
	
	public static VendorResponseDTO toDTO(Vendor vendor) {
		
		return new VendorResponseDTO(
				
				vendor.getId(),
				vendor.getName(),
				vendor.getEmail(),
				vendor.getPhone(),
				vendor.getAddress()
				);
		
	}
	
}
