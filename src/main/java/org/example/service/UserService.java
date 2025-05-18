package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repo;
    public String addUser(User users) {
        repo.save(users);
        return "User details Registered Success";
    }

    public List<User> getUser() {
        List<User> users = repo.findAll();
        if (users.isEmpty()) {
            return new ArrayList<>();  // Return an empty list if no data is found
        }
        return users;
    }



}

