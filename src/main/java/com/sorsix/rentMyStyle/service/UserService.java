package com.sorsix.rentMyStyle.service;

import com.sorsix.rentMyStyle.domain.User;
import com.sorsix.rentMyStyle.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> getUser(String id){
        return repository.findById(id);
    }

    public Optional<User> addUser(User user){

        User newUser = repository.findById(user.getId())
                .orElseGet(() -> repository.save(user));

        return Optional.of(newUser);
    }

}
