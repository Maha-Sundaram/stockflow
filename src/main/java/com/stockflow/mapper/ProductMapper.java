package com.stockflow.mapper;


import com.stockflow.dto.ProductRequestDTO;
import com.stockflow.dto.ProductResponseDTO;
import com.stockflow.entity.Product;
import com.stockflow.entity.Vendor;

public class ProductMapper {


	public static Product toEntity(ProductRequestDTO dto, Vendor vendor) {

		Product product = new Product();

		product.setName(dto.getName());

		product.setCategory(dto.getCatogery());

		product.setPrice(dto.getPrice());

		product.setVendor(vendor);

		return product;

	}


	public static ProductResponseDTO toDTO(Product product) {

		return new ProductResponseDTO(
				product.getId(),
				product.getName(),
				product.getCategory(),
				product.getPrice(),
				product.getVendor().getName()
				);

	}
}
