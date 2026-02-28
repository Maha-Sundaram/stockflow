package com.stockflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockflow.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByVendor_Id(Long vendorId);
	
}
