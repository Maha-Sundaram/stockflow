package com.stockflow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stockflow.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	@Query("""
			SELECT i FROM Inventory i
			WHERE i.quantity < i.reorderLevel
			""")
	List<Inventory> findLowStockProducts();
	
	Optional<Inventory> findByProductId(Long productId);
	
}
