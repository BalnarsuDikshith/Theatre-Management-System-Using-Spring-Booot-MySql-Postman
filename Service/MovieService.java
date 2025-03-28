package com.qsp.Theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Moviedao;
import com.qsp.Theatre_management_system.dto.Movie;
import com.qsp.Theatre_management_system.dto.Review;
import com.qsp.Theatre_management_system.dto.Viewer;
import com.qsp.Theatre_management_system.exception.MovieIdNotFound;
import com.qsp.Theatre_management_system.dto.Movie;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@Service
public class MovieService {

	@Autowired
	Moviedao moviedao;
	
	@Autowired
	ResponseStructure<Movie> responseStructure;
	@Autowired
	ResponseStructureList<Movie> responseStructureList;
	
	public ResponseStructure<Movie> saveMovie(Movie movie) {
		
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Movie inserted into DB");
		responseStructure.setData(moviedao.saveMovie(movie));
		return responseStructure;
	}	
	
	public Movie addExistingViewerToExistingMovie(int viewerId,int movieId) {
		return moviedao.addExistingViewerToExistingMovie(viewerId, movieId);
		}
		
	public Movie addNewViewerToExistingMovie(int movieId, Viewer newViewer) {
			return moviedao.addNewViewerToExistingMovie(movieId, newViewer);
			}
	
	public Movie addExistingReviewToExistingMovie(int reviewId,int movieId) {
		return moviedao.addExistingReviewToExistingMovie(reviewId, movieId);
		}
		
	public Movie addNewReviewToExistingMovie(int movieId, Review newReview) {
			return moviedao.addNewReviewToExistingMovie(movieId, newReview);
			}
	
	public ResponseStructure<Movie> fetchMovieById(int movieId) {
		Movie movie=moviedao.fetchMovieById(movieId);
		if(movie!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Movie fetched from DB");
		responseStructure.setData(moviedao.fetchMovieById(movieId));
		return responseStructure;
		}else {
			throw new MovieIdNotFound();
		}
	}
	
	public ResponseStructureList<Movie> fetchAllMovie(){
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Owners Fetched from DB");
		responseStructureList.setData(moviedao.fetchAllMovie());
		return responseStructureList;
	}
	
	public ResponseStructure<Movie> deleteMovieById(int movieId) {
		Movie movie=moviedao.fetchMovieById(movieId);
		if(movie!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Movie deleted in DB");
		responseStructure.setData(moviedao.deleteMovieById(movieId));
	    return responseStructure;
		}else {
			throw new MovieIdNotFound();
		}
	    
	}
	
	public ResponseStructure<Movie> updateMovieById(int oldMovieId,Movie newMovie)
	{
		Movie movie=moviedao.fetchMovieById(oldMovieId);
		if(movie!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Movie Updated into DB");
		responseStructure.setData(moviedao.updateMovieById(oldMovieId,newMovie));
		return responseStructure;
		}else {
			throw new MovieIdNotFound();
		}
	}
	
	
}
