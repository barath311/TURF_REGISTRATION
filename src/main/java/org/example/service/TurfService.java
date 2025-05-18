package org.example.service;

import org.example.model.Turf;
import org.example.repository.TurfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurfService {
    @Autowired
    TurfRepository repo;

    public String addTurf(List<Turf> turf) {
        repo.saveAll(turf);
        return "success";
    }

    public List<Turf> getAllTurfs() {
        return repo.findAll();
    }

    public Optional<Turf> getById(Long id) {
        return repo.findById(id);
    }

    public String updateTurf(Turf turf) {
        Optional<Turf> exists=repo.findById(turf.getId());
        if(exists.isPresent()){
            repo.save(turf);
            return "Update Success";
        }
        else{
            return "No data Exists";
        }
    }

    public String deleteById(Long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Delete Success";
        }
        else{
            return "No data Exists";
        }

    }

    public String deleteAll() {
        repo.deleteAll();
        return "DELETED ALL SUCCESS";
    }
}
