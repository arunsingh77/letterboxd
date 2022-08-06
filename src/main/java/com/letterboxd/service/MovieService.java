package com.letterboxd.service;

import com.letterboxd.model.Movie;

public interface MovieService {

	Movie getMovieWithReview(String movieName);
	String addMovie(Movie movie);
	String updateMovie(Movie movie);
	String deleteMovie(String movieName);
	

}
