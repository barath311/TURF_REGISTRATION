package org.example.controller;

import org.example.model.Booking;
import org.example.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createBooking(
            @RequestParam("turfId") Long turfId,
            @RequestParam("userId") Long userId
    ) {
        String result = bookingService.simpleBooking(turfId, userId);
        return ResponseEntity.ok(result);
    }
    @GetMapping("get")
    public List<Booking> getALl(){
        return bookingService.getAll();
    }
}
