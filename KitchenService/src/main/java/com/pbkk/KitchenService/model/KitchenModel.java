package com.pbkk.KitchenService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class KitchenModel {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_dostatus;
	private Integer id_detailorder;
	private Integer id_order;
	private Boolean detailorder_status;
	private Integer jumlah;
	
	public Integer getId_dostatus() {
		return id_dostatus;
	}
	public void setId_dostatus(Integer id_dostatus) {
		this.id_dostatus = id_dostatus;
	}
	
	public Integer getId_detailorder() {
		return id_detailorder;
	}
	public void setId_detailorder(Integer id_detailorder) {
		this.id_detailorder = id_detailorder;
	}
	
	public Boolean getStatus() {
		return detailorder_status;
	}
	public void setStatus(Boolean status) {
		this.detailorder_status = status;
	}
	public Integer getId_order() {
		return id_order;
	}
	public void setId_order(Integer id_order) {
		this.id_order = id_order;
	}
	public Integer getJumlah() {
		return jumlah;
	}
	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}

}