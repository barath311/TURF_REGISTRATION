package org.example.repository;

import org.example.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {
    Optional<AppUser> findByUsername(String username); // safer for null
    boolean existsByUsername(String username);
}
