package org.example.controller;

import org.example.model.Turf;
import org.example.service.TurfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class TurfController {
    @Autowired
    private TurfService service;

    @PostMapping("/add/turf")
    public String addturf(@RequestBody List<Turf> turf){
        return service.addTurf(turf);
    }
    @GetMapping("get/turf")
    public List<Turf> getAllTurfs(){
        return service.getAllTurfs();
    }
    @GetMapping("get/turf/id/{id}")
    public Optional<Turf> getById(@PathVariable("id") Long id){
        return service.getById(id);
    }
    @PutMapping("put/turf")
    public String updateTurf(@RequestBody Turf turf){
        return service.updateTurf(turf);
    }
    @DeleteMapping("/delete/turf/{id}")
    public String deleteById(@PathVariable("id") Long id){
        return service.deleteById(id);
    }
    @DeleteMapping("/delete-all")
    public String deleteALl(){
        return service.deleteAll();
    }

}
