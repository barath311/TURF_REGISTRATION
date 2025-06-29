package org.example.service;

import org.example.model.AppUser;

import org.example.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    AppUserRepo repo;
    public String addUser(AppUser users) {
        repo.save(users);
        return "User details Registered Success";
    }

    public List<AppUser> getUser() {
        List<AppUser> users = repo.findAll();
        if (users.isEmpty()) {
            return new ArrayList<>();  // Return an empty list if no data is found
        }
        return users;
    }


    public String update(AppUser users) {
        repo.save(users);
        return "Updated Successfully";

}

    public Optional<String> deleteUser(Long id) {
        try {
            if (repo.existsById(id)) {
                repo.deleteById(id);
                return Optional.of("Delete Success");
            } else {
                return Optional.of("No data Exists");
            }
        } catch (Exception e) {
            e.printStackTrace();  // Check the exact error in the console
            return Optional.of("Error: " + e.getMessage());
        }
    }


    }


