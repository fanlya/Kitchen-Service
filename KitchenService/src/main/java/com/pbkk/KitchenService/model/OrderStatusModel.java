package com.pbkk.KitchenService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class OrderStatusModel {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_ostatus;
	private Integer id_order;
	private Integer order_status;
	
	public Integer getId_ostatus() {
		return id_ostatus;
	}
	public void setId_ostatus(Integer id_ostatus) {
		this.id_ostatus = id_ostatus;
	}
	
	public Integer getId_order() {
		return id_order;
	}
	public void setId_order(Integer id_order) {
		this.id_order = id_order;
	}
	
	public Integer getStatus() {
		return order_status;
	}
	public void setStatus(Integer status) {
		this.order_status = status;
	}
	
}