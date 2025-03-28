package com.qsp.Theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Viewerdao;
import com.qsp.Theatre_management_system.dto.Food;
import com.qsp.Theatre_management_system.dto.Owner;
import com.qsp.Theatre_management_system.dto.Viewer;
import com.qsp.Theatre_management_system.exception.ViewerIdNotFound;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@Service
public class ViewerService {
	
	@Autowired
	Viewerdao viewerdao;
	@Autowired
	ResponseStructure<Viewer> responseStructure;
	
	@Autowired
	ResponseStructureList<Viewer> responseStructureList;
	
	
	public ResponseStructure<Viewer> saveViewer(Viewer viewer) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("SuccessfullyViewer inserted into DB");
		responseStructure.setData(viewerdao.saveViewer(viewer));
		return responseStructure;
	}
	
	public Viewer addExistingFoodToExistingViewer(int foodId,int viewerId) {
		return viewerdao.addExistingFoodToExistingViewer(foodId, viewerId);
	}
	
	public Viewer addNewFoodToExistingViewer(int viewerId,Food newFood) {
		return viewerdao.addNewFoodToExistingViewer(viewerId, newFood);
	}
	
	public ResponseStructure<Viewer> fetchViewerById(int viewerId) {
		Viewer viewer=viewerdao.fetchViewerById(viewerId);
		if(viewer!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Viewer fetched from DB");
		responseStructure.setData(viewerdao.fetchViewerById(viewerId));
		return responseStructure;
		}else {
			throw new ViewerIdNotFound();
		}
	}
	
	public ResponseStructureList<Viewer> fetchAllViewer(){
		
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Viewers Fetched from DB");
		responseStructureList.setData(viewerdao.fetchAllViewer());
		return responseStructureList;
	}
	
	public ResponseStructure<Viewer> deleteViewerById(int viewerId) {
		Viewer viewer=viewerdao.fetchViewerById(viewerId);
		if(viewer!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Viewer deleted in DB");
		responseStructure.setData(viewerdao.deleteViewerById(viewerId));
	    return responseStructure;
		}else {
			throw new ViewerIdNotFound();
		}
	}
	
	public ResponseStructure<Viewer> updateViewerById(int oldViewerId, Viewer newViewer) {
		Viewer viewer=viewerdao.fetchViewerById(oldViewerId);
		if(viewer!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Viewer Updated into DB");
		responseStructure.setData(viewerdao.updateViewerById(oldViewerId, newViewer));
		return responseStructure;
		}else {
			throw new ViewerIdNotFound();
		}
	}}