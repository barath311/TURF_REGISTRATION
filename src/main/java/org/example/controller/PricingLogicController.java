package org.example.controller;

import org.example.model.PricingLogic;
import org.example.service.PricingLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pricing")
public class PricingLogicController {

    @Autowired
    private PricingLogicService service;

    // Add a new pricing rule
    @PostMapping("/add")
    public String addPricingRule(@RequestBody PricingLogic logic) {
        return service.addPricingLogic(logic);
    }

    // Get all pricing rules
    @GetMapping("/all")
    public List<PricingLogic> getAllPricingRules() {
        return service.getAllPricingRules();
    }

    // Get pricing rules for a specific turf
    @GetMapping("/turf/{turf_id}")
    public List<PricingLogic> getPricingByTurf(@PathVariable("turf_id") Long turfId) {
        return service.getByTurfId(turfId);
    }

    // (Optional) Deactivate a pricing rule
    @PutMapping("/deactivate/{id}")
    public String deactivateRule(@PathVariable Long id) {
        return service.deactivateRule(id);
    }
}
