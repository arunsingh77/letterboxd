package com.letterboxd.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letterboxd.dao.ReviewDao;
import com.letterboxd.model.Review;
import com.letterboxd.service.ReviewService;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	ReviewDao reviewDao;

	@Override
	public Review getReview(int userId) {
		return reviewDao.getReview(userId);
	}

	@Override
	public String addReview(Review review) {
		String res= reviewDao.addReview(review);
		if(res.equals("Done")) {
			return reviewDao.updateRating(review);
		}
		return "Done";
	}

	@Override
	public String updateReview(Review review) {
		String res= reviewDao.updateReview(review);
		if(res.equals("Done")) {
			return reviewDao.updateRating(review);
		}
		return "Done";
	}

}
