package com.sorsix.rentMyStyle.repository;

import com.sorsix.rentMyStyle.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findAllByBrandIgnoreCase(String brand);
    List<Item> findAllByColorIgnoreCase(String color);
    List<Item> findAllBySizeIgnoreCase(String size);
    List<Item> findAllByPriceLessThan(Integer price);
    List<Item> findAllByNameContainingIgnoreCase(String string);
}
