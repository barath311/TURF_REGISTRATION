package org.example.repository;

import org.example.model.PricingLogic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PricingLogicRepository extends JpaRepository<PricingLogic, Long> {
    List<PricingLogic> findByTurfIdAndIsActiveTrue(Long turfId);
}
