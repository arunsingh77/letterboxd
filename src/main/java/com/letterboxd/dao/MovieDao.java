package com.letterboxd.dao;

import com.letterboxd.model.Movie;

public interface MovieDao {

	Movie getMovieWithReview(String movieName);
	String addMovie(Movie movie);
	String updateMovie(Movie movie);
	String deleteMovie(String movieName);

}
