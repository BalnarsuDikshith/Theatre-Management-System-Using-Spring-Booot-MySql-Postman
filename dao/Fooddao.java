package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Food;
import com.qsp.Theatre_management_system.repo.FoodRepo;

@Repository
public class Fooddao {

	@Autowired
	FoodRepo foodRepo;
	
	public Food saveFood(Food food) {
		return foodRepo.save(food);
	}
	
	public Food fetchFoodById(int foodId) {
		Optional<Food> dbFood=foodRepo.findById(foodId);
		if(dbFood.isPresent()) {
			return dbFood.get();
		}else {
			return null;
		}
		
	}
	
	public List<Food> fetchAllFood(){
		return foodRepo.findAll();
	}
	
	public Food deleteFoodById(int foodId) {
		Food food= foodRepo.findById(foodId).get();
	foodRepo.delete(food);
		return food;
	}
	
	public Food updateFoodById(int oldFoodId, Food newFood) {
		newFood.setFoodId(oldFoodId);
		return foodRepo.save(newFood);
	}
}
