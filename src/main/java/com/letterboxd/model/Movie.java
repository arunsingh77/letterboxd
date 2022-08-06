package com.letterboxd.model;

import java.util.List;

public class Movie {
	String movieName;
	String director;
	String desc;
	String lang;
	float rating;
	List<Review>reviews;
	
	

	public Movie() {
		
	}

	public Movie(String movieName, String director, String desc, String lang, float rating, List<Review> reviews) {
		
		this.movieName = movieName;
		this.director = director;
		this.desc = desc;
		this.lang = lang;
		this.rating = rating;
		this.reviews = reviews;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", director=" + director + ", desc=" + desc + ", lang=" + lang
				+ ", rating=" + rating + ", reviews=" + reviews + "]";
	}

	
	

}
