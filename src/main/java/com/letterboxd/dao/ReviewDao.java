package com.letterboxd.dao;

import com.letterboxd.model.Review;

public interface ReviewDao {
	Review getReview(int userId);
	String addReview(Review review);
	String updateReview(Review review);
	String updateRating(Review review);
	

}
