package com.sorsix.rentMyStyle.service;

import com.sorsix.rentMyStyle.domain.Item;
import com.sorsix.rentMyStyle.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Optional<Item> getItem(Integer id){
        return repository.findById(id);
    }

    public Optional<Item> addItem(Item item){
        repository.save(item);
        return Optional.of(item);
    }

    public Optional<List<Item>> getAll() {
        return Optional.of(repository.findAll());
    }

    public Optional<List<Item>> getAllByColor(String color) {
        return Optional.of(repository.findAllByColorIgnoreCase(color));
    }

    public Optional<List<Item>> getAllByBrand(String brand) {
        return Optional.of(repository.findAllByBrandIgnoreCase(brand));
    }

    public Optional<List<Item>> getAllBySize(String size) {
        return Optional.of(repository.findAllBySizeIgnoreCase(size));
    }

    public Optional<List<Item>> getAllByPrice(Integer price) {
        return Optional.of(repository.findAllByPriceLessThan(price));
    }

    public Optional<List<Item>> getAllByName(String string) {
        return Optional.of(repository.findAllByNameContainingIgnoreCase(string));
    }
}
