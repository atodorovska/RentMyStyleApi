package com.sorsix.rentMyStyle.service;

import com.sorsix.rentMyStyle.domain.Review;
import com.sorsix.rentMyStyle.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ReviewService {

    private ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public Optional<Review> getReview(Integer id){
        return repository.findById(id);
    }

    public Optional<Review> addReview(Review review){

        repository.save(review);
        return Optional.of(review);
    }
}
