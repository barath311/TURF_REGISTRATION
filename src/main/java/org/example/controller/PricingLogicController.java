package org.example.controller;

import org.example.model.PricingLogic;
import org.example.service.PricingLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PricingLogicController {

    @Autowired
    private PricingLogicService service;

    // Add a new pricing rule
    @PostMapping("/admin/pricing/add")
    public String addPricingRule(@RequestBody PricingLogic logic) {
        return service.addPricingLogic(logic);
    }

    // Get all pricing rules
    @GetMapping("/public/pricing/all")
    public List<PricingLogic> getAllPricingRules() {
        return service.getAllPricingRules();
    }

    // Get pricing rules for a specific turf
    @GetMapping("/public/pricing/turf/{turf_id}")
    public List<PricingLogic> getPricingByTurf(@PathVariable("turf_id") Long turfId) {
        return service.getByTurfId(turfId);
    }

    // (Optional) Deactivate a pricing rule
    @PutMapping("/admin/pricing/update/{id}")
    public String update(@RequestBody PricingLogic logic) {
        return service.update(logic);
    }
}
