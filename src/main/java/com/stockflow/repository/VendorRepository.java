package com.stockflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockflow.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long>{

}