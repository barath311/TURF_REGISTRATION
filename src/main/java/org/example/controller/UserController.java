package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/add/user")
    public String addUser(@RequestBody User users){
        return service.addUser(users);
    }
    @GetMapping("/get/user")
    public List<User> getUser(){
        return service.getUser();
    }


}
