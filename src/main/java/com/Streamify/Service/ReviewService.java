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

    public Boolean deleteReviewById(Long id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review.equals(null)){
            return false;
        }
        else {
            reviewRepository.deleteById(id);
            return true;
        }
    }
    public Review updateReview(Long reviewId, Review updatedReview) {
        // Zoek de bestaande beoordeling op basis van het reviewId
        Review existingReview = reviewRepository.findById(reviewId).orElse(null);

        if (existingReview != null) {
            // Update de beoordeling met de nieuwe waarden
            existingReview.setScore(updatedReview.getScore());
            existingReview.setUser(updatedReview.getUser());
            existingReview.setVideo(updatedReview.getVideo());

            // Sla de bijgewerkte beoordeling op in de database
            return reviewRepository.save(existingReview);
        }

        // Retourneer null of gooi een exceptie als de beoordeling niet gevonden is
        return null;
    }


//    public double getAverageRatingByVideoId(Long videoId) {
//        return reviewRepository.getAverageRatingByVideoId(videoId);
//    }
}
