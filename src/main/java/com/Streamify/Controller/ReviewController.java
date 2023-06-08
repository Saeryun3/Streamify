package com.Streamify.Controller;

import com.Streamify.Model.Review;
import com.Streamify.Model.User;
import com.Streamify.Model.Video;
import com.Streamify.Service.ReviewService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

@Autowired
    private ReviewService reviewService;
    @GetMapping("/{reviewId}")
    public Review getReviewById(@PathVariable Long reviewId){
        return reviewService.getReviewById(reviewId);
    }
    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody ObjectNode json){
        Review review = new Review();

        User user = new User();
        user.setId(json.get("userId").asInt());

        Video video = new Video();
        video.setVideoId(json.get("videoId").asLong());

        review.setUser(user);
        review.setVideo(video);
        review.setScore(json.get("score").asInt());
        reviewService.saveReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body("Je beoordeling is opgeslagen");
    }
    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<String>deleteReview(@PathVariable Long reviewId){
        Boolean isDeleted = reviewService.deleteReviewById(reviewId);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Review with id" + reviewId + "is been deleted");
    }

    @PutMapping("/update/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long reviewId, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(reviewId, review);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

}
