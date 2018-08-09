package com.sorsix.rentMyStyle.controller;

import com.sorsix.rentMyStyle.domain.User;
import com.sorsix.rentMyStyle.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{user}")
    public ResponseEntity<User> getUserFromDB(@PathVariable String user){
        return service.getUser(user).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/post")
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        return service.addUser(user).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

}
