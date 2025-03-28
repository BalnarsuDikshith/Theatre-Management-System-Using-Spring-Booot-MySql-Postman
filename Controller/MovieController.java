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

import com.qsp.Theatre_management_system.dto.Movie;
import com.qsp.Theatre_management_system.dto.Review;
import com.qsp.Theatre_management_system.dto.Viewer;
import com.qsp.Theatre_management_system.service.MovieService;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@PostMapping("/saveMovie")
	public ResponseStructure<Movie> saveMovie( @RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}
	
	@PutMapping("/addExistingViewerToExistingMovie")
	public Movie addExistingViewerToExistingMovie(@RequestParam int viewerId,@RequestParam int movieId) {
		return movieService.addExistingViewerToExistingMovie(viewerId, movieId);
		}
		
	@PutMapping("/addNewViewerToExistingMovie")
	public Movie addNewViewerToExistingMovie(@RequestParam int movieId,@RequestBody Viewer newViewer) {
			return movieService.addNewViewerToExistingMovie(movieId, newViewer);
			}
	
	@PutMapping("/addExistingReviewToExistingMovie")
	public Movie addExistingReviewToExistingMovie(@RequestParam int reviewId,@RequestParam int movieId) {
		return movieService.addExistingReviewToExistingMovie(reviewId, movieId);
		}
	@PutMapping("/addNewReviewToExistingMovie")	
	public Movie addNewReviewToExistingMovie(@RequestParam int movieId,@RequestBody Review newReview) {
			return movieService.addNewReviewToExistingMovie(movieId, newReview);
			}
	
	
	
	@GetMapping("/fetchMovieById")
	public ResponseStructure<Movie> fetchMovieById(@RequestParam int movieId) {
		return movieService.fetchMovieById(movieId);
	}
	
	@GetMapping("/fetchAllMovie")
	public ResponseStructureList<Movie> fetchAllMovie(){
		return movieService.fetchAllMovie();
	}
	
	@DeleteMapping("/deleteMovieById")
	public ResponseStructure<Movie> deleteMovieById(@RequestParam int movieId) {
		return movieService.deleteMovieById(movieId);
	}
	
	@PutMapping("/updateMovieById")
	public ResponseStructure<Movie> updateMovieById(@RequestParam int oldMovieId,@RequestBody Movie newMovie) {
		return movieService.updateMovieById(oldMovieId, newMovie);
	}

}
