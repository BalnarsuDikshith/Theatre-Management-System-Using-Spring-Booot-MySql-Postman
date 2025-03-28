package com.qsp.Theatre_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Theatre_management_system.dto.Food;
import com.qsp.Theatre_management_system.service.FoodService;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@RestController
public class FoodController {

	@Autowired
	FoodService foodService;
	
	@PostMapping("/saveFood")
	public ResponseStructure<Food> saveFood(@RequestBody Food food) {
		return foodService.saveFood(food);
	}
	
	@GetMapping("/fetchFoodById")
	public ResponseStructure<Food> fetchFoodById(@RequestParam int foodId) {
		return foodService.fetchFoodById(foodId);
	}
	
	@GetMapping("/fetchAllFood")
	public ResponseStructureList<Food> fetchAllFood(){
		return foodService.fetchAllFood();
	}
	
	@DeleteMapping("/deleteFoodById")
	public ResponseStructure<Food> deleteFoodById(@RequestParam int foodId) {
		return foodService.deleteFoodById(foodId);
	}
	
	@PutMapping("/updateFoodById")
	public ResponseStructure<Food> updateFoodById(@RequestParam int oldFoodId,@RequestBody Food newFood) {
		return foodService.updateFoodById(oldFoodId, newFood);
	}
}
