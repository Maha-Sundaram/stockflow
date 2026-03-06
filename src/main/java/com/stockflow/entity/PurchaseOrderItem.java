package com.stockflow.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class PurchaseOrderItem extends BaseEntity {

	
	@ManyToOne
	@JoinColumn(name = "purchase_order_id")
	@JsonIgnore
	private PurchaseOrder purchaseOrder;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	private Integer quantity;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal price;
	
	public PurchaseOrderItem() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrderItem(PurchaseOrder purchaseOrder, Product product, Integer quantity, BigDecimal price) {
		super();
		this.purchaseOrder = purchaseOrder;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
