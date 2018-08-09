package com.sorsix.rentMyStyle.repository;

import com.sorsix.rentMyStyle.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
