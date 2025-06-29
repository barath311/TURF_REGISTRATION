package org.example.controller;
import org.example.model.Booking;
import org.example.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/user/booking/create")
    public ResponseEntity<String> createBooking(
            @RequestParam("turfId") Long turfId,
            @RequestParam("userId") Long userId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
            @RequestParam("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime
    ) {
        String result = bookingService.simpleBooking(turfId, userId, date, startTime, endTime);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/admin/get")
    public List<Booking> getALl(){
        return bookingService.getAll();
    }
    @DeleteMapping("/admin/delete/booking/{id}")
    public Optional<String> Delete(@PathVariable("id") Long id){
        return bookingService.DeleteById(id);
    }
}
