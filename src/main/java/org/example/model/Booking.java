package org.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Turf turf;

    @ManyToOne
    private AppUser user;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    public Booking() {}

    public Booking(Long id, AppUser user, Turf turf, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.user = user;
        this.turf = turf;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Turf getTurf() { return turf; }
    public void setTurf(Turf turf) { this.turf = turf; }

    public AppUser getUser() { return user; }
    public void setUser(AppUser user) { this.user = user; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
}
