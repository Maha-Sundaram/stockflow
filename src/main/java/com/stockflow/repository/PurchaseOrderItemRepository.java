package com.stockflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockflow.entity.PurchaseOrderItem;

public interface PurchaseOrderItemRepository extends JpaRepository<PurchaseOrderItem, Long>{

}
