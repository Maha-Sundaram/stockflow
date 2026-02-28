package com.stockflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockflow.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long>{

}
