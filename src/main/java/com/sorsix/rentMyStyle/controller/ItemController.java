package com.sorsix.rentMyStyle.controller;

import com.sorsix.rentMyStyle.domain.Item;
import com.sorsix.rentMyStyle.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/{item}")
    public ResponseEntity<Item> getItemFromDB(@PathVariable Integer item){
        return service.getItem(item).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/post")
    public ResponseEntity<Item> addNewItem(@RequestBody Item item){
        return service.addItem(item).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }
}
