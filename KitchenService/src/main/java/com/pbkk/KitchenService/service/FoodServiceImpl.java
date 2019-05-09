package com.pbkk.KitchenService.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pbkk.KitchenService.model.FoodModel;
import com.pbkk.KitchenService.model.KitchenModel;
@Service
public class FoodServiceImpl implements FoodService {
	@Override
	public void createFood(String name, Integer Cost, Integer restaurant_Id, Boolean status) {
		this.foodmodels.add(new FoodModel(restaurant_Id, name, Cost, status));
		
	}

	@Override
	public FoodModel getFoodbyID(Integer id_food) {
		return foodmodels.stream()
				.filter(x -> x.getId_food().intValue()  == id_food.intValue())
				.findAny()
				.orElse(null);
	}

	@Override
	public void setFoodStatus(Integer id_food, Boolean status) {
		// TODO Auto-generated method stub
		foodmodels.stream()
		.filter(x -> x.getId_food()  == id_food)
		.findAny()
		.orElseThrow(() -> new RuntimeException("Item not found"))
		.setFoodStatus(status);
	}

	@Override
	public void deleteFood(Integer id_food) {
		// TODO Auto-generated method stub
		foodmodels.removeIf((FoodModel u) -> u.getId_food() == id_food);
	}

	@Override
	public void updateFoodName(Integer id_food, String foodName) {
		// TODO Auto-generated method stub
		foodmodels.stream()
		.filter(x -> x.getId_food()  == id_food)
		.findAny()
		.orElseThrow(() -> new RuntimeException("Item not found"))
		.setFoodName(foodName);
	}

	@Override
	public void updateFoodCost(Integer id_food, Integer cost) {
		// TODO Auto-generated method stub
		foodmodels.stream()
		.filter(x -> x.getId_food()  == id_food)
		.findAny()
		.orElseThrow(() -> new RuntimeException("Item not found"))
		.setFoodCost(cost);
	}
	public static List<FoodModel> foodmodels;
	public FoodServiceImpl() {
		foodmodels = new LinkedList<>();
		foodmodels.add(new FoodModel(0 ,"Mie goreng",8000, false));
		foodmodels.add(new FoodModel(1 ,"Mie bakar",18000, false));
		foodmodels.add(new FoodModel(2 ,"Mie Panggang",118000, false));
	}

	@Override
	public List<FoodModel> getAll() {
		return this.foodmodels;
	}
}
