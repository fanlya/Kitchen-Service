package com.pbkk.KitchenService.model;

public class FoodModel {
	private Integer id_restaurant;	
	private String foodName;
	private Boolean foodStatus;
	private Integer foodCost ;
	private Integer id_food;
	
	private static Integer id_counter = 0; 
	
	public FoodModel(Integer id_restaurant, String foodName,Integer cost,  Boolean status) {
		this.id_restaurant = id_restaurant;
		this.foodName = foodName;
		this.foodStatus = status;
		this.id_food = id_counter;
		this.foodCost = cost;
		id_counter++;
	}
	public Integer getId_food() {
		return id_food;
	}

	public void setId_food(Integer id_food) {
		this.id_food = id_food;
	}
	public Boolean getFoodStatus() {
		return foodStatus;
	}
	public void setFoodStatus(Boolean foodStatus) {
		this.foodStatus = foodStatus;
	}
	public Integer getFoodCost() {
		return foodCost;
	}
	public void setFoodCost(Integer cost) {
		this.foodCost = cost;
	}
	public Integer getId_restaurant() {
		return id_restaurant;
	}
	public void setId_restaurant(Integer id_restaurant) {
		this.id_restaurant = id_restaurant;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
}
