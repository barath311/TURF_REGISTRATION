package org.example.service;

import org.example.model.PricingLogic;
import org.example.repository.PricingLogicRepository;
import org.example.repository.TurfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingLogicService {

    @Autowired
    TurfRepository repo1;
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

    public String update(PricingLogic logic) {
        // Check if the turf is valid
        if (logic.getTurf() == null || logic.getTurf().getId() == null || !repo1.existsById(logic.getTurf().getId())) {
            return "No turf exists";
        }

        // Check if the pricing logic ID exists
        if (logic.getId() == null || !repo.existsById(logic.getId())) {
            return "Pricing logic not found";
        }

        // Fetch the existing entity
        PricingLogic existingLogic = repo.findById(logic.getId()).get();

        // Update fields
        existingLogic.setTurf(logic.getTurf());
        existingLogic.setTimeSlotStart(logic.getTimeSlotStart());
        existingLogic.setTimeSlotEnd(logic.getTimeSlotEnd());
        existingLogic.setRateIncrease(logic.getRateIncrease());
        existingLogic.setActive(logic.isActive());

        // Save updated entity
        repo.save(existingLogic);

        return "Pricing logic updated successfully";
    }

}