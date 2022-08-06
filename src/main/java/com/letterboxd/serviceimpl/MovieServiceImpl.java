package com.letterboxd.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letterboxd.dao.MovieDao;
import com.letterboxd.model.Movie;
import com.letterboxd.service.MovieService;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	@Autowired
	MovieDao movieDao;

	@Override
	public Movie getMovieWithReview(String movieName) {
		return movieDao.getMovieWithReview(movieName);
	}

	@Override
	public String addMovie(Movie movie) {
		return movieDao.addMovie(movie);
	}

	@Override
	public String updateMovie(Movie movie) {
		return movieDao.updateMovie(movie);
	}

	@Override
	public String deleteMovie(String movieName) {
		return movieDao.deleteMovie(movieName);
	}

}
