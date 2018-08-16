package com.sorsix.rentMyStyle.controller;

import com.sorsix.rentMyStyle.domain.Review;
import com.sorsix.rentMyStyle.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping("/{review}")
    public ResponseEntity<Review> getReviewFromDB(@PathVariable Integer review){
        return service.getReview(review).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/post")
    public ResponseEntity<Review> addNewReview(@RequestBody Review review){
        return service.addReview(review).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }
}
