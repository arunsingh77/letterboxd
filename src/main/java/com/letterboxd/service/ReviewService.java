package com.letterboxd.service;

import com.letterboxd.model.Review;

public interface ReviewService {
	Review getReview(int userId);
	String addReview(Review review);
	String updateReview(Review review);

}
