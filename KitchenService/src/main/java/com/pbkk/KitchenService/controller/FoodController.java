package com.pbkk.KitchenService.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pbkk.KitchenService.model.*;
import com.pbkk.KitchenServiceUtil.*;
import com.pbkk.KitchenService.service.*;

@RestController
@RequestMapping("/Food")

public class FoodController {
//	@Autowired
	FoodService foodService;
	@ResponseBody
	@RequestMapping("")
	public List<FoodModel> test() {
		return foodService.getAll();
//		return Util.getSuccessResult(kitchenService.getAll())
	}
	@ResponseBody
	@RequestMapping("/{id}")
	public FoodModel getKitchen(@PathVariable("id") Integer id) {
		return foodService.getFoodbyID(id);
	}	
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteStatus(
			@PathVariable("id") Integer id_status) {
		   
	    foodService.deleteFood(id_status); 
	    return Util.getSuccessResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "/createFood", method = RequestMethod.POST)
	public Map<String, Object> createFood(			
			@RequestParam(value = "name") String name,
			@RequestParam(value = "Cost") Integer Cost,
			@RequestParam(value = "restaurant_Id") Integer restaurant_Id,
			@RequestParam(value = "status") Boolean status
			) {
		
		foodService.createFood(name, Cost, restaurant_Id, status);
		return Util.getSuccessResult();
	}
	@ResponseBody
	@RequestMapping(value = "/putName", method = RequestMethod.PUT)
	public Map<String, Object> updateFoodName(
			@RequestParam(value = "id_food") Integer id_food,
			@RequestParam(value = "food name") String foodName
			) {
		
		foodService.updateFoodName(id_food, foodName);		
		return Util.getSuccessResult();
	}
	@ResponseBody
	@RequestMapping(value = "/putCost", method = RequestMethod.PUT)
	public Map<String, Object> updateFoodCost(
			@RequestParam(value = "id_food") Integer id_food,
			@RequestParam(value = "food cost") Integer cost
			) {
		
		foodService.updateFoodCost (id_food, cost);;		
		return Util.getSuccessResult();
	}
	
}
