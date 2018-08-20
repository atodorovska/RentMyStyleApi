package com.sorsix.rentMyStyle.repository;

import com.sorsix.rentMyStyle.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
