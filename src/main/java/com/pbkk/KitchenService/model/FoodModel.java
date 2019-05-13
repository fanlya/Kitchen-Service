package com.pbkk.KitchenService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class FoodModel {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_mstatus;
	private Integer id_makanan;
	private Boolean makanan_status;
	
	public Integer getId_mstatus() {
		return id_mstatus;
	}
	public void setId_mstatus(Integer id_mstatus) {
		this.id_mstatus = id_mstatus;
	}
	
	public Integer getId_makanan() {
		return id_makanan;
	}
	public void setId_makanan(Integer id_makanan) {
		this.id_makanan = id_makanan;
	}
	
	public Boolean getStatus() {
		return makanan_status;
	}
	public void setStatus(Boolean status) {
		this.makanan_status = status;
	}
	
}