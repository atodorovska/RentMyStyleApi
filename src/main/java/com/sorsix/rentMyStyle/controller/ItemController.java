package com.sorsix.rentMyStyle.controller;

import com.sorsix.rentMyStyle.domain.Item;
import com.sorsix.rentMyStyle.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/{item}")
    public ResponseEntity<Item> getItemFromDB(@PathVariable Integer item){
        return service.getItem(item).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAll(){
        return service.getAll().map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all/brand/{brand}")
    public ResponseEntity<List<Item>> getAllByBrand(@PathVariable String brand){
        return service.getAllByBrand(brand).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all/color/{color}")
    public ResponseEntity<List<Item>> getAllByColor(@PathVariable String color){
        return service.getAllByColor(color).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all/size/{size}")
    public ResponseEntity<List<Item>> getAllBySize(@PathVariable String size){
        return service.getAllBySize(size).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all/price/{price}")
    public ResponseEntity<List<Item>> getAllByPrice(@PathVariable Integer price){
        return service.getAllByPrice(price).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/post")
    public ResponseEntity<Item> addNewItem(@RequestBody Item item){
        return service.addItem(item).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }
}
