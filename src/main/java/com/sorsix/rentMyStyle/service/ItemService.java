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
}
