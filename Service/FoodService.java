package com.qsp.Theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Fooddao;
import com.qsp.Theatre_management_system.dto.Food;
import com.qsp.Theatre_management_system.exception.FoodIdNotFound;
import com.qsp.Theatre_management_system.dto.Food;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@Service
public class FoodService {

	@Autowired
	Fooddao fooddao;
	
	@Autowired
	ResponseStructure<Food> responseStructure;
	@Autowired
	ResponseStructureList<Food> responseStructureList;
	
	public ResponseStructure<Food> saveFood(Food food) {
		
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Food inserted into DB");
		responseStructure.setData(fooddao.saveFood(food));
		return responseStructure;
	}
	
	public ResponseStructure<Food> fetchFoodById(int foodId) {
		Food food=fooddao.fetchFoodById(foodId);
		if(food!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Food fetched from DB");
		responseStructure.setData(fooddao.fetchFoodById(foodId));
		return responseStructure;
		}else {
			throw new FoodIdNotFound();
		}
	}
	
	public ResponseStructureList<Food> fetchAllFood(){
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Food Fetched from DB");
		responseStructureList.setData(fooddao.fetchAllFood());
		return responseStructureList;
	}
	
	public ResponseStructure<Food> deleteFoodById(int foodId) {
		Food food=fooddao.fetchFoodById(foodId);
		if(food!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Food deleted in DB");
		responseStructure.setData(fooddao.deleteFoodById(foodId));
	    return responseStructure;
		}else {
			throw new FoodIdNotFound();
		}
	    
	}
	
	public ResponseStructure<Food> updateFoodById(int oldFoodId,Food newFood)
	{
		Food food=fooddao.fetchFoodById(oldFoodId);
		if(food!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Food Updated into DB");
		responseStructure.setData(fooddao.updateFoodById(oldFoodId,newFood));
		return responseStructure;
		}else {
			throw new FoodIdNotFound();
		}
	}
	
}
