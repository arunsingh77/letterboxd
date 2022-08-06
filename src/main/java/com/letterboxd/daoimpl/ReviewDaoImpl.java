package com.letterboxd.daoimpl;

import java.sql.ResultSet;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.letterboxd.dao.ReviewDao;
import com.letterboxd.model.Review;
import com.letterboxd.util.SqlConstants;

@Component
public class ReviewDaoImpl implements ReviewDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Review getReview(int userId) {
		Object[] names= {userId};
		int[] types= {Types.INTEGER};
		Review review = jdbcTemplate.query(SqlConstants.GET_REVIEW_QUERY,names,types,(ResultSet rs)->{
			if(rs.next()) {
				return new Review(rs.getInt("user_id"),rs.getString("movie_name"),rs.getString("review"),rs.getFloat("rating"));
			}
			else {
				return null;
			}
		});
		
		return review;
	}

	@Override
	public String addReview(Review review) {
		Object[] names= {review.getUserId(),review.getMovieName(),review.getReview(),review.getRating()};
		int[] types= {Types.INTEGER,Types.VARCHAR,Types.VARCHAR,Types.NUMERIC};
		jdbcTemplate.update(SqlConstants.ADD_REVIEW_QUERY,names,types);
		
		return "Done";
	}

	@Override
	public String updateReview(Review review) {
		Object[] names= {review.getReview(),review.getRating(),review.getUserId(),review.getMovieName()};
		int[] types= {Types.VARCHAR,Types.NUMERIC,Types.INTEGER,Types.VARCHAR};
		jdbcTemplate.update(SqlConstants.UPDATE_REVIEW_QUERY,names,types);
		
		return "Done";
	}

	@Override
	public String updateRating(Review review) {
		Object[] names= {review.getMovieName(),review.getMovieName()};
		int[] types= {Types.VARCHAR,Types.VARCHAR};
		jdbcTemplate.update(SqlConstants.UPDATE_RATING_QUERY, names,types);
		
		return "Done";
	}

}
