package org.example.controller;

import org.example.model.AppUser;

import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("public/add/user")
    public String addUser(@RequestBody AppUser users){
        return service.addUser(users);
    }
    @GetMapping("/admin/get/user")
    public List<AppUser> getUser(){
        return service.getUser();
    }
    @PutMapping("/admin/put/user")
    public String Update(@RequestBody AppUser users){
        return service.update(users);
    }
    @DeleteMapping("/admin/delete/user/{id}")
    public Optional<String> deleteUser(@PathVariable("id") Long id) {
        return service.deleteUser(id);
    }

}
