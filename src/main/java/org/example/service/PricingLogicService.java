package org.example.service;

import org.example.model.PricingLogic;
import org.example.repository.PricingLogicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingLogicService {

    @Autowired
    private PricingLogicRepository repo;

    public String addPricingLogic(PricingLogic logic) {
        repo.save(logic);
        return "Pricing logic added successfully";
    }

    public List<PricingLogic> getAllPricingRules() {
        return repo.findAll();
    }

    public List<PricingLogic> getByTurfId(Long turfId) {
        return repo.findByTurfIdAndIsActiveTrue(turfId);
    }

    public String deactivateRule(Long id) {
        PricingLogic logic = repo.findById(id).orElseThrow(() -> new RuntimeException("Rule not found"));
        logic.setActive(false);
        repo.save(logic);
        return "Pricing rule deactivated";
    }
}
