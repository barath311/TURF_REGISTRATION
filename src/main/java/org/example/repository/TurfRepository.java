package org.example.repository;

import org.example.model.Turf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurfRepository extends JpaRepository<Turf,Long> {
}
