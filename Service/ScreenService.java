package com.qsp.Theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Screendao;
import com.qsp.Theatre_management_system.dto.Movie;
import com.qsp.Theatre_management_system.dto.Screen;
import com.qsp.Theatre_management_system.exception.ScreenIdNotFound;
import com.qsp.Theatre_management_system.dto.Screen;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@Service
public class ScreenService {
	
	@Autowired
	Screendao screendao;
	
	@Autowired
	ResponseStructure<Screen> responseStructure;
	@Autowired
	ResponseStructureList<Screen> responseStructureList;
	
	public ResponseStructure<Screen> saveScreen(Screen screen) {
		
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Screen inserted into DB");
		responseStructure.setData(screendao.saveScreen(screen));
		return responseStructure;
	}
	
	public Screen addExistingMovieToExistingScreen(int movieId,int screenId) {
		return screendao.addExistingMovieToExistingScreen(movieId, screenId);
	}
	
	public ResponseStructure<Screen> fetchScreenById(int screenId) {
		Screen screen=screendao.fetchScreenById(screenId);
		if(screen!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Screen fetched from DB");
		responseStructure.setData(screendao.fetchScreenById(screenId));
		return responseStructure;
		}else {
			throw new ScreenIdNotFound();
		}
	}
	
	public ResponseStructureList<Screen> fetchAllScreen(){
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Screens Fetched from DB");
		responseStructureList.setData(screendao.fetchAllScreen());
		return responseStructureList;
	}
	
	public ResponseStructure<Screen> deleteScreenById(int screenId) {
		Screen screen=screendao.fetchScreenById(screenId);
		if(screen!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Screen deleted in DB");
		responseStructure.setData(screendao.deleteScreenById(screenId));
	    return responseStructure;
		}else {
			throw new ScreenIdNotFound();
		}
	    
	}
	
	public ResponseStructure<Screen> updateScreenById(int oldScreenId,Screen newScreen)
	{
		Screen screen=screendao.fetchScreenById(oldScreenId);
		if(screen!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Screen Updated into DB");
		responseStructure.setData(screendao.updateScreenById(oldScreenId,newScreen));
		return responseStructure;
		}else {
			throw new ScreenIdNotFound();
		}
	}

}
