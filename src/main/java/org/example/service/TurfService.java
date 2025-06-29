package org.example.service;

import org.example.model.Turf;
import org.example.repository.TurfRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurfService {
    @Autowired
    TurfRepository repo;

    private static final Logger logger = LoggerFactory.getLogger(TurfService.class);


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
        if (repo.existsById(id)) {
            try {
                repo.deleteById(id);
                return "Delete Success";
            } catch (DataIntegrityViolationException e) {
                // Log the specific exception for debugging
                logger.error("Attempt to delete Turf with ID {} failed due to foreign key constraint: {}", id, e.getMessage());
                // Return a user-friendly error message
                return "Cannot delete turf because it is associated with existing bookings or other records. Please delete associated records first.";
            } catch (Exception e) {
                // Catch any other unexpected exceptions
                logger.error("An unexpected error occurred while deleting Turf with ID {}: {}", id, e.getMessage());
                return "An unexpected error occurred during deletion: " + e.getMessage();
            }}
        else{
            return "No data Exists";
        }

    }

    public String deleteAll() {
        repo.deleteAll();
        return "DELETED ALL SUCCESS";
    }
}
