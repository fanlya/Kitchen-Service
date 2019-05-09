package com.pbkk.KitchenService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class KitchenModel {
	private Integer id_status = 0;
	
	private Integer id_order;
	private String status;
	private static Integer id_counter = 100;
	
	public KitchenModel( Integer id_order){
		id_counter++;
		this.id_order = id_order;
		this.id_status = id_counter;
		this.status = "belum";
	}
	public Integer getId_status() {
		return id_status;
	}
	public void setId_status(Integer id_status) {
		this.id_status = id_status;
	}
	public Integer getId_order() {
		return id_order;
	}
	public void setId_order(Integer id_order) {
		this.id_order = id_order;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
