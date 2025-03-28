package com.qsp.Theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Theatre_management_system.dto.Food;
import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.dto.Viewer;
import com.qsp.Theatre_management_system.repo.ViewerRepo;

@Repository
public class Viewerdao {

	@Autowired
	ViewerRepo viewerRepo;
	@Autowired
	Fooddao fooddao;
	
	public Viewer saveViewer(Viewer viewer) {
		return viewerRepo.save(viewer);
	}
	
	public Viewer addExistingFoodToExistingViewer(int foodId,int viewerId) {
		Food food=fooddao.fetchFoodById(foodId);
		Viewer viewer=fetchViewerById(viewerId);
		List<Food> list=viewer.getFoods();
		list.add(food);
		viewer.setFoods(list);
		return saveViewer(viewer);
	}
	
	public Viewer addNewFoodToExistingViewer(int viewerId,Food newFood) {
		Viewer viewer=fetchViewerById(viewerId);
		List<Food> list=viewer.getFoods();
		list.add(newFood);
		viewer.setFoods(list);
		return saveViewer(viewer);
	}
	
	public Viewer fetchViewerById(int viewerId) {
		Optional<Viewer> dbViewer= viewerRepo.findById(viewerId);
		if(dbViewer.isPresent()) {
			return dbViewer.get();
		}else {
			return null;
		}
	}
	
	public List<Viewer> fetchAllViewer(){
		return viewerRepo.findAll();
	}
	
	public Viewer deleteViewerById(int viewerId) {
		Viewer viewer= viewerRepo.findById(viewerId).get();
	viewerRepo.delete(viewer);
		return viewer;
	}
	
	public Viewer updateViewerById(int oldViewerId, Viewer newViewer) {
		newViewer.setViewerId(oldViewerId);
		return viewerRepo.save(newViewer);
	}
}
