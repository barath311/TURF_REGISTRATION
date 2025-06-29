package org.example.repository;

import org.example.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE b.turf.id = :turfId AND b.date = :date " +
            "AND (b.startTime < :endTime AND b.endTime > :startTime)")
    List<Booking> findConflictingBookings(
            @Param("turfId") Long turfId,
            @Param("date") LocalDate date,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime
    );
}