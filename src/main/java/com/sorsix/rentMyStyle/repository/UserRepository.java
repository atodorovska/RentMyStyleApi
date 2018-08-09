package com.sorsix.rentMyStyle.repository;

import com.sorsix.rentMyStyle.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// the generic is definced as JpaRepository<ItemClass, ItemIdType> !

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
