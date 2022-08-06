package com.letterboxd.daoimpl;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.letterboxd.dao.MovieDao;
import com.letterboxd.model.Movie;
import com.letterboxd.model.Review;
import com.letterboxd.util.SqlConstants;

@Component
public class MovieDaoImpl implements MovieDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Movie getMovieWithReview(String movieName) {
		Object[] names = { movieName };
		int[] types = { Types.VARCHAR };
		Movie res = jdbcTemplate.query(SqlConstants.GET_MOVIE_QUERY, names, types, (ResultSet rs) -> {
			Movie movie = new Movie();
			ArrayList<Review> reviews = new ArrayList<>();

			while (rs.next()) {
				if (movie.getMovieName() == null) {
					movie.setMovieName(rs.getString("movie_name"));
					movie.setDirector(rs.getString("director"));
					movie.setDesc(rs.getString("description"));
					movie.setLang(rs.getString("lang"));
					movie.setRating(rs.getFloat("rating"));
				}
				Review review = new Review();
				review.setUserId(rs.getInt("user_id"));
				review.setMovieName(rs.getString("movie_name"));
				review.setReview(rs.getString("review"));
				review.setRating(rs.getFloat("user_rating"));

				reviews.add(review);

			}
			movie.setReviews(reviews);
			return movie;

		});

		return res;
	}

	@Override
	public String addMovie(Movie movie) {
		Object[] names = { movie.getMovieName(), movie.getDirector(), movie.getDesc(), movie.getLang(),
				movie.getRating() };
		int[] types = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.NUMERIC };
		jdbcTemplate.update(SqlConstants.ADD_MOVIE_QUERY, names, types);

		return "Done";
	}

	@Override
	public String updateMovie(Movie movie) {
		Object[] names = { movie.getDirector(), movie.getDesc(), movie.getLang(), movie.getRating(),
				movie.getMovieName() };
		int[] types = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.NUMERIC, Types.VARCHAR };
		jdbcTemplate.update(SqlConstants.UPDATE_MOVIE_QUERY, names, types);

		return "Done";
	}

	@Override
	public String deleteMovie(String movieName) {
		Object[] names = { movieName };
		int[] types = { Types.VARCHAR };
		jdbcTemplate.update(SqlConstants.DELETE_MOVIE_QUERY, names, types);

		return "Done";
	}

}
