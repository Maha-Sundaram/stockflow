package com.stockflow.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity

public class PurchaseOrder extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;
	
	private String status;
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal totalAmount;
	
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
	private List<PurchaseOrderItem> items;
	
	public PurchaseOrder() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrder(Vendor vendor, String status, BigDecimal totalAmount, List<PurchaseOrderItem> items) {
		super();
		this.vendor = vendor;
		this.status = status;
		this.totalAmount = totalAmount;
		this.items = items;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<PurchaseOrderItem> getItems() {
		return items;
	}

	public void setItems(List<PurchaseOrderItem> items) {
		this.items = items;
	}
	
}
