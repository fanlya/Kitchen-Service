package com.pbkk.KitchenService.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class FoodModel {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_fstatus;
	private Integer id_makanan;
	private Boolean food_status;
	
	public void setId_makanan(Integer id_makanan) {
		this.id_makanan = id_makanan;
	}
	public Integer getId_fstatus() {
		return id_fstatus;
	}
	
	public void setId_fstatus(Integer id_fstatus) {
		this.id_fstatus = id_fstatus;
	}
	public Integer getId_makanan() {
		return id_makanan;
	}
	
	public Boolean getStatus() {
		return food_status;
	}
	public void setStatus(Boolean status) {
		this.food_status = status;
	}

	
}
