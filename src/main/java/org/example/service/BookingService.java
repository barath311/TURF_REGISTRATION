package org.example.service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.example.model.AppUser;
import org.example.model.Booking;
import org.example.model.Turf;
import org.example.repository.AppUserRepo;
import org.example.repository.BookingRepo;
import org.example.repository.TurfRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepo bookingRepo;
    private final TurfRepository turfRepository;
    private final AppUserRepo appUserRepo;

    public BookingService(BookingRepo bookingRepo, TurfRepository turfRepository, AppUserRepo appUserRepo) {
        this.bookingRepo = bookingRepo;
        this.turfRepository = turfRepository;
        this.appUserRepo = appUserRepo;
    }

    public String simpleBooking(Long turfId, Long userId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        Turf turf = turfRepository.findById(turfId)
                .orElseThrow(() -> new RuntimeException("Turf not found"));

        AppUser user = appUserRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Booking> conflicts = bookingRepo.findConflictingBookings(turfId, date, startTime, endTime);
        if (!conflicts.isEmpty()) {
            return "Turf is already booked during this time. Please choose another time slot.";
        }

        Booking booking = new Booking();
        booking.setTurf(turf);
        booking.setUser(user);
        booking.setDate(date);
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);

        bookingRepo.save(booking);

        return "Booking successful! User: " + user.getUsername() + ", Amount: ₹" + turf.getBaseRate() + ", Turf Name: " + turf.getName();
    }

    public List<Booking> getAll() {
        return bookingRepo.findAll();
    }

    public Optional<String> DeleteById(Long id) {
        try {
            if (bookingRepo.existsById(id)) {
                // Fetch booking to get user details before deleting
                Booking booking = bookingRepo.findById(id).orElse(null);

                if (booking != null) {
                    String userName = booking.getUser().getUsername(); // Adjust based on your model
                    Long userId = booking.getUser().getId();

                    bookingRepo.deleteById(id);

                    return Optional.of("Booking deleted for user: " + userName + " (ID: " + userId + ")");
                } else {
                    return Optional.of("Booking exists but couldn't retrieve details.");
                }

            } else {
                return Optional.of("No booking data exists for ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.of("Error: " + e.getMessage());
        }
    }

}
