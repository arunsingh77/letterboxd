package com.letterboxd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letterboxd.model.Review;
import com.letterboxd.service.ReviewService;

@RestController
@RequestMapping("/letterboxd")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/review/{userId}")
	public Review getReview(@PathVariable int userId) {
		return reviewService.getReview(userId);
	}
	
	@PostMapping("/review/addreview")
	public String addReview(@RequestBody Review review) {
		return reviewService.addReview(review);
	}
	
	@PutMapping("/review/{userId}/update/{movieName}")
	public String updateReview(@PathVariable String movieName,@PathVariable int userId, @RequestBody Review review) {
		return reviewService.updateReview(review);
	}
}
