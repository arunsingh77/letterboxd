package com.letterboxd.model;

public class Review {
	int userId;
	String movieName;
	String review;
	float rating;
	
	public Review(int userId, String movieName, String review, float rating) {
		super();
		this.userId = userId;
		this.movieName = movieName;
		this.review = review;
		this.rating = rating;
	}

	public Review() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [userId=" + userId + ", movieName=" + movieName + ", review=" + review + ", rating=" + rating
				+ "]";
	}
	
	

}
