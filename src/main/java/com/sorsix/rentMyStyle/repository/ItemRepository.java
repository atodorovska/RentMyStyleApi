package com.sorsix.rentMyStyle.repository;

import com.sorsix.rentMyStyle.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
