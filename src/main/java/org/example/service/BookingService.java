package org.example.service;

import org.example.model.Booking;
import org.example.model.Turf;
import org.example.model.User;
import org.example.repository.BookingRepository;
import org.example.repository.TurfRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository repo;

    private final TurfRepository turfRepository;
    private final UserRepository userRepository;

    public BookingService(TurfRepository turfRepository, UserRepository userRepository) {
        this.turfRepository = turfRepository;
        this.userRepository = userRepository;
    }

    public String simpleBooking(Long turfId, Long userId) {
        Turf turf = turfRepository.findById(turfId)
                .orElseThrow(() -> new RuntimeException("Turf not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return "Booking successful! User: " + user.getName() + ", Amount: ₹" + turf.getBaseRate() + ", Turf Name:" + turf.getName();
    }

    public List<Booking> getAll() {
        return repo.findAll();
    }
}
