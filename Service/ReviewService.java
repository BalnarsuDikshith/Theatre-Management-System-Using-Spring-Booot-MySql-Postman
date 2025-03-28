package com.qsp.Theatre_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Theatre_management_system.dao.Reviewdao;
import com.qsp.Theatre_management_system.dto.Review;
import com.qsp.Theatre_management_system.exception.ReviewIdNotFound;
import com.qsp.Theatre_management_system.dto.Review;
import com.qsp.Theatre_management_system.util.ResponseStructure;
import com.qsp.Theatre_management_system.util.ResponseStructureList;

@Service
public class ReviewService {

	@Autowired
	Reviewdao reviewdao;
	
	@Autowired
	ResponseStructure<Review> responseStructure;
	@Autowired
	ResponseStructureList<Review> responseStructureList;
	
	public ResponseStructure<Review> saveReview(Review review) {
		
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Review inserted into DB");
		responseStructure.setData(reviewdao.saveReview(review));
		return responseStructure;
	}
	
	public ResponseStructure<Review> fetchReviewById(int reviewId) {
		Review review=reviewdao.fetchReviewById(reviewId);
		if(review!=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Review fetched from DB");
		responseStructure.setData(reviewdao.fetchReviewById(reviewId));
		return responseStructure;
		}else {
			throw new ReviewIdNotFound();
		}
	}
	
	public ResponseStructureList<Review> fetchAllReview(){
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully All Reviews Fetched from DB");
		responseStructureList.setData(reviewdao.fetchAllReview());
		return responseStructureList;
	}
	
	public ResponseStructure<Review> deleteReviewById(int reviewId) {
		Review review=reviewdao.fetchReviewById(reviewId);
		if(review!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Review deleted in DB");
		responseStructure.setData(reviewdao.deleteReviewById(reviewId));
	    return responseStructure;
		}else {
			throw new ReviewIdNotFound();
		}
	}
	
	public ResponseStructure<Review> updateReviewById(int oldReviewId,Review newReview)
	{
		Review review=reviewdao.fetchReviewById(oldReviewId);
		if(review!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Review Updated into DB");
		responseStructure.setData(reviewdao.updateReviewById(oldReviewId,newReview));
		return responseStructure;
		}else {
			throw new ReviewIdNotFound();
		}
	}
}
