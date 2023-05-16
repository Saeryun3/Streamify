package com.Streamify.Service;

import com.Streamify.Model.Review;
import com.Streamify.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }

//    public double getAverageRatingByVideoId(Long videoId) {
//        return reviewRepository.getAverageRatingByVideoId(videoId);
//    }
}
