package com.letterboxd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letterboxd.model.Movie;
import com.letterboxd.service.MovieService;

@RestController
@RequestMapping("/letterboxd")
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@GetMapping("/movie/{movieName}")
	public Movie getMovieWithReview(@PathVariable String movieName) {
		return movieService.getMovieWithReview(movieName);
	}
	
	@PostMapping("/movie/addmovie")
	public String addMovie(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}
	
	@PutMapping("/movie/update/{movieName}")
	public String updateMovie(@PathVariable String movieName,@RequestBody Movie movie) {
		return movieService.updateMovie(movie);
	}
	
	@DeleteMapping("/deletemovie/{movieName}")
    public String deleteMovie(@PathVariable String movieName) {
		return movieService.deleteMovie(movieName);
	}
    
	

}
